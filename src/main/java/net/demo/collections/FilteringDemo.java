package net.demo.collections;

import lombok.Getter;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
class Book {
    private String title;
    private LocalDate releaseDate;

    public Book(String title, LocalDate releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }
}

public class FilteringDemo {
    public static void main(String[] args) {
        var books = new ArrayList<Book>(List.of(
                new Book("The Outsider", LocalDate.of(2019, 1, 1)),
                new Book("Becoming", LocalDate.of(2018, 1, 1)),
                new Book("Uri", LocalDate.of(2017, 1, 1))));

        Predicate<Book> p = b -> b.getReleaseDate()
                .isAfter(IsoChronology.INSTANCE.date(2018, 1, 1));

        Set<String> newBooks1 = books.stream().collect(Collectors.filtering(
                p,Collectors.mapping(Book::getTitle, Collectors.toSet())));

        List<Book> newBooks = books.stream().collect(Collectors.filtering(p, Collectors.toList()));
        Set<String> newBooks2 = books.stream().collect(Collectors.partitioningBy(p)).get(false)
                .stream().map(b->b.getTitle()).collect(Collectors.toSet());

        System.out.println(newBooks);
        System.out.println(newBooks1);
        System.out.println(newBooks2);
    }
}
