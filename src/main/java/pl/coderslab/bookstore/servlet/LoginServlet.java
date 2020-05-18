package pl.coderslab.bookstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String EMAIL_PATTERN = "^[a-z0-9.\\-_]+@[a-z0-9\\-_]+\\.[a-z]{2,3}$";
    private static final String PASSWORD_PATTERN = "[a-z0-9]{4,8}";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // sprawdzenie czy uzytkownik jest zalogowany

        HttpSession session = req.getSession();

        Object object = session.getAttribute("login");

        if (object != null) {   // jest zalogowany
            // jezeli jest zalogowany to redirect na stan koszyka
            resp.sendRedirect("/bookstore/shoppingcart/books");
        } else {
            // jeżeli nie jest zalogowany to wyświetlamy formularz do logowania
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/login.html")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");



        // pobieramy parametry email oraz password
        // walidacja czy parametr email reprezentuje email
        // 1. małpka,
        // 2. przed małpką jedynie małe litery, -, _, .cyfry
        // 3. po małpce jeden człon jedynie małe litery, -, _, .cyfry
        // 4. kropka
        // 5. maksymalnie 3 znaki - tylko małe litery

        // ala-ma.kota12@test.pl - poprawne


        // walidacja hasła
        // minimalnie 4 znaków, maksymalnie 8 znaków
        // małe litery, cyfry

        // sprawdzamy czy email i hasło są poprawne marcin.troscianczyk@coderslab.pl qwerty12


        // jak email i haslo poprawne
        // zaznaczamy w sesji że użytkownik się zalogował i redirect na stan koszyka

        // jeżeli dane logowania nie są poprawne ponownie wyśweitlamy formularz logowania z
        // informacją, że niepoprawne dane logowania
        System.out.println("Odebrałem żądanie");
    }
}
