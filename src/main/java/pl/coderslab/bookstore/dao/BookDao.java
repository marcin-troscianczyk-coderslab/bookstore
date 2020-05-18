package pl.coderslab.bookstore.dao;

import pl.coderslab.bookstore.model.Book;

import java.util.Arrays;
import java.util.List;

public class BookDao {

    private static final List<Book> BOOKS =
            Arrays.asList(new Book(1, "W pustyni i w puszczy", "Henryk Sienkiewicz", 99.99f),
                    new Book(2, "Pan Tadeusz", "Adam Mickiewicz", 50.34f),
                    new Book(3, "Thinking in java", "Bruce Eckel", 123.00f));

    public List<Book> findAllBooks() {
        return BOOKS;
    }
}
