package net.demo.streams;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Getter
@Setter
class Book {
    private int id;
    private String title;
    private String genre;
    private String author;

    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public static class BookFilter implements Predicate<Book> {

        @Override
        public boolean test(Book book) {
            return book.getGenre().equals("fiction");
        }
    }
}


public class StreamTest1 {
    public static void main(String[] args) throws Exception {
        List<Book> books = Arrays.asList(new Book("30 Days", "fiction", "K Larsen"),
                new Book("Fast Food Nation", "non-fiction", "Eric Schlosser"),
                new Book("Wired", "fiction", "D Richards"));

        books.stream()
                .filter(b -> new Book.BookFilter().test(b))
                .forEach((Book b) -> System.out.println(b.getTitle() + ", "));

        System.out.print(Float.parseFloat("0.0f"));
    }
}
