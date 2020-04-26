package pl.coderslab.bookstore.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
}
