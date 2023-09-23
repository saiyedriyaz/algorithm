package net.demo.functions;

import java.io.Closeable;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

interface Printable {
    String print(String prefix, String suffix);
}

public class LambdaDemo {

    public static void main(String[] args) {
        List<String> cities = List.of("USA", "Netherlands", "UK", "India", "France");
        Comparator<String> c = String::compareTo; //1
        Comparator<String> cr = c.reversed();//2
        String joined = cities.stream()
                .sorted(cr)
                .collect(Collectors.joining(", "));//3
        System.out.println(joined);
        var v1 = StandardCopyOption.REPLACE_EXISTING;
    }
}
