package pl.coderslab.bookstore.servlet;

import pl.coderslab.bookstore.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/books")
public class AddBookServlet extends HttpServlet {

    private final BookDao bookDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("books", bookDao.findAllBooks());

        getServletContext().getRequestDispatcher("/WEB-INF/views/books.jsp")
                .forward(req, resp);
    }
}
