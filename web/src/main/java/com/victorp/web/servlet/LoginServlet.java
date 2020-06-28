package com.victorp.web.servlet;

import com.victorp.model.Contact;
import com.victorp.services.AuthorizationService;
import com.victorp.services.impl.AuthorizationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static com.victorp.web.filter.AuthenticationFilter.USER_ID_PARAM;

@WebServlet(name = "LoginServlet" , urlPatterns = "/auth")
public class LoginServlet extends HttpServlet {

    public static final String LOGIN_PARAM = "login";
    public static final String PASSWORD_PARAM = "password";

    private final AuthorizationService authorizationService = AuthorizationServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter(LOGIN_PARAM);
        final String password = req.getParameter(PASSWORD_PARAM);

        final Contact contact = authorizationService.authorize(login, password);

        final String contextPath = req.getContextPath();

        if (contact == null) {
            resp.sendRedirect(contextPath + "/login.html");
        } else {
            final HttpSession session = req.getSession();
            session.setAttribute(USER_ID_PARAM, contact.getId());

            final Cookie myOwnCookie = new Cookie("MyOwnCookie", "PC");
            resp.addCookie(myOwnCookie);
            req.setAttribute("username", contact.getFirstName() + " " + contact.getLastName());
            resp.setContentType("text/html");

            final RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
            dispatcher.include(req, resp);
        }
    }
}
