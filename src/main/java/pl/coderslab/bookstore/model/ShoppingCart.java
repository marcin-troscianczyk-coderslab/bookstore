package pl.coderslab.bookstore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public Map<Integer, Integer> getBooksHistogram() {

        Map<Integer, Integer> histogram = new HashMap<>();

        for (Book book : books) {

            int id = book.getId();

            Integer value = histogram.get(id);

            if (value != null) {
                histogram.put(id, value + 1);
            } else {
                histogram.put(id, 1);
            }
        }

        return histogram;
    }

    public Map<Integer, List<Book>> getBookHistogram2() {

        Map<Integer, List<Book>> histogram = new HashMap<>();

        for (Book book : books) {

            int id = book.getId();

            List<Book> value = histogram.get(id);

            if (value != null) {
                value.add(book);
            } else {
                value = new ArrayList<>();
                value.add(book);
                histogram.put(id, value);
            }

        }

        return histogram;
    }
}
