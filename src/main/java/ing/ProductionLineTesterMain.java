package ing;

import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
class Product {
    @Getter
    private String status;
}

@ToString
class ProductLineTestReport {

    long correctCounter;      // number of correct products
    long checkedExcCounter;   // number of products which threw a checked exception during verification
    long uncheckedExcCounter; // number of products which threw an unchecked exception during verification
    long otherExcCounter;     // number of products which threw an error during verification

    ProductLineTestReport(long correctCounter, long checkedExcCounter, long uncheckedExcCounter, long otherExcCounter) {
        this.correctCounter = correctCounter;
        this.checkedExcCounter = checkedExcCounter;
        this.uncheckedExcCounter = uncheckedExcCounter;
        this.otherExcCounter = otherExcCounter;
    }
}

interface ProductVerifier {
    void verify(Product product) throws Exception;
}

class ProductionLineTester {

    private final ProductVerifier verifier;

    ProductionLineTester(ProductVerifier verifier) {
        this.verifier = verifier;
    }

    ProductLineTestReport test(Stream<Product> products) {
        AtomicInteger checkedExcCounter = new AtomicInteger();
        AtomicInteger uncheckedExcCounter = new AtomicInteger();
        AtomicInteger otherExcCounter = new AtomicInteger();
        AtomicInteger correctCounter = new AtomicInteger();

        if (products != null) {
            List<Product> validProducts = products
                    .filter(Objects::nonNull)
                    .filter(product -> !"invalid".equalsIgnoreCase(product.getStatus()))
                    .skip(10)
                    .limit(20)
                    .collect(Collectors.toList());

            validProducts.forEach(product -> {
                try {
                    verifier.verify(product);
                    correctCounter.getAndIncrement();
                } catch (RuntimeException re) {
                    uncheckedExcCounter.getAndIncrement();
                } catch (Exception e) {
                    checkedExcCounter.getAndIncrement();
                } catch (Error error) {
                    otherExcCounter.getAndIncrement();
                }
            });
        }

        return new ProductLineTestReport(correctCounter.get(), checkedExcCounter.get(), uncheckedExcCounter.get(), otherExcCounter.get());
    }
}

public class ProductionLineTesterMain {
    public static void main(String[] args) {
        val pList = List.of(
                new Product("valid"), new Product("invalid"), new Product(),
                new Product("valid"), new Product("invalid"), new Product(),
                new Product("valid"), new Product("invalid"), new Product(),
                new Product("valid"), new Product("invalid"), new Product(),
                new Product("valid"), new Product("invalid"), new Product(),
                new Product("valid"), new Product("invalid"), new Product(),
                new Product("valid"), new Product("invalid"), new Product()
        );

        AtomicInteger tester = new AtomicInteger();
        val productionLineTester = new ProductionLineTester(product -> {
            tester.getAndIncrement();
            if (tester.get() % 2 == 0) {
                throw new Exception("dummy");
            } else {
                System.out.println("verified okay");
            }
        });
        System.out.println(productionLineTester.test(pList.stream()));
        System.out.println(productionLineTester.test(null));
    }
}



