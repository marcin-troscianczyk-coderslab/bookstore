package pl.coderslab.bookstore.servlet;

import pl.coderslab.bookstore.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/shoppingcart/books")
public class ShoppingCartServlet extends HttpServlet {

    private static final String SHOPPING_CART_SESSION_ATTRIBUTE_NAME = "shoppingcart";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Object o = session.getAttribute(SHOPPING_CART_SESSION_ATTRIBUTE_NAME);

        if (o instanceof ShoppingCart) {
            ShoppingCart sc = (ShoppingCart) o;

            req.setAttribute("books", sc.getBooks());
            req.setAttribute("histogram", sc.getBooksHistogram());
            req.setAttribute("histogram2", sc.getBookHistogram2());
        }

        getServletContext().getRequestDispatcher("/WEB-INF/views/shoppingcart.jsp")
                .forward(req, resp);
    }
}
