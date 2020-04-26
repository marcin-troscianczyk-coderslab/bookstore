package pl.coderslab.bookstore.servlet;

import pl.coderslab.bookstore.model.Book;
import pl.coderslab.bookstore.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/shoppingcart/addbook")
public class AddBookToShoppingCartServlet extends HttpServlet {

    private static final String SHOPPING_CART_SESSION_ATTRIBUTE_NAME = "shoppingcart";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        try {

            int bookId = Integer.parseInt(id);

            for (Book book : AddBookServlet.BOOKS) {
                if (book.getId() == bookId) {

                    HttpSession session = request.getSession();

                    Object o = session.getAttribute(SHOPPING_CART_SESSION_ATTRIBUTE_NAME);

                    if (o instanceof ShoppingCart) {
                        ShoppingCart sc = (ShoppingCart) o;
                        sc.addBook(book);
                    } else {

                        ShoppingCart sc = new ShoppingCart();
                        sc.addBook(book);
                        session.setAttribute(SHOPPING_CART_SESSION_ATTRIBUTE_NAME, sc);
                    }
                }
            }
            // TODO: To przekierowanie nie do końca działa tak jak powinno tj. adres ma jaki zostaje przekierowany użytkownik jest blędny. Jak to możemy poprawić?
            // TODO: Utworzyć zasówb GET shopping/books prezentujący w postaci tabelarycznej wszystkie książki znajdujące się w koszyku
            // TODO: Sprawdzić jak zachowuje się koszyk zakupów tzn. jakie elementy się w nim znajdują w przypadku kiedy logujemy się z różnych przeglądarek (różne sesje)
            response.sendRedirect("shoppingcart/books");

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // TODO: Zaimplementować metodę doGet - jej kod będzie taki sam jak metody doPost - jak możemy uniknąć duplikacji kodu?
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
