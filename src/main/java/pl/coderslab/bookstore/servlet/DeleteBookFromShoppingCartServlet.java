package pl.coderslab.bookstore.servlet;

import pl.coderslab.bookstore.dao.BookDao;
import pl.coderslab.bookstore.model.Book;
import pl.coderslab.bookstore.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/shoppingcart/deletebook")
public class DeleteBookFromShoppingCartServlet extends HttpServlet {

    private static final String SHOPPING_CART_SESSION_ATTRIBUTE_NAME = "shoppingcart";

    private final BookDao bookDao = new BookDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] ids = request.getParameterValues("id");

        try {

            for (String id : ids) {

                int bookId = Integer.parseInt(id);

                for (Book book : bookDao.findAllBooks()) {
                    if (book.getId() == bookId) {

                        HttpSession session = request.getSession();

                        Object o = session.getAttribute(SHOPPING_CART_SESSION_ATTRIBUTE_NAME);

                        if (o instanceof ShoppingCart) {
                            ShoppingCart sc = (ShoppingCart) o;
                            sc.deleteBook(book);
                        }
                    }
                }
            }

            response.sendRedirect("/bookstore/shoppingcart/books");

        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
