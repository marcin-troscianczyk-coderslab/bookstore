package pl.coderslab.bookstore.servlet;

import pl.coderslab.bookstore.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/books")
public class AddBookServlet extends HttpServlet {

    // TODO: utworzyć klasę BookDao, posiadającą instancyjną metodę public List<Book> findAllBooks() zwracającą wszystkie książki z bazy danych (tabela books)
    // TODO: Zastąpić użycie statycznego pola BOOKS przez BookDao
    static final List<Book> BOOKS =
            Arrays.asList(new Book(1, "W pustyni i w puszczy", "Henryk Sienkiewicz", 99.99f),
                    new Book(2, "Pan Tadeusz", "Adam Mickiewicz", 50.34f),
                    new Book(3, "Thinking in java", "Bruce Eckel", 123.00f));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("books", BOOKS);

        getServletContext().getRequestDispatcher("/WEB-INF/views/books.jsp")
                .forward(req, resp);
    }
}
