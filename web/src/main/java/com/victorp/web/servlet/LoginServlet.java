package com.victorp.web.servlet;

import com.victorp.model.User;
import com.victorp.services.AuthorizationService;
import com.victorp.services.impl.AuthorizationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static com.victorp.web.filter.AuthenticationFilter.*;

@WebServlet(name = "LoginServlet" , urlPatterns = "/auth")
public class LoginServlet extends HttpServlet {

    public static final String LOGIN_PARAM = "login";
    public static final String PASSWORD_PARAM = "password";

    private final AuthorizationService authorizationService = AuthorizationServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter(LOGIN_PARAM);
        final String password = req.getParameter(PASSWORD_PARAM);

        final User user;

        try {
            user = authorizationService.authorizeUser(login, password);
            final String contextPath = req.getContextPath();
            if(user != null){
                final HttpSession session = req.getSession();
                    session.setAttribute(USER_ID_PARAM, user.getId());
                    session.setAttribute(STATUS_ADMIN, user.getUserRole().getAdmin());
                    session.setAttribute(STATUS_TRAINER, user.getUserRole().getTrainer());
                    req.setAttribute("username", user.getFirstName() + " " + user.getLastName());
                    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                    final Cookie myOwnCookie = new Cookie("MyOwnCookie", "PC");
                    resp.addCookie(myOwnCookie);
            }else{
                resp.sendRedirect(contextPath + "/login.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html;charset=UTF-8");
        final RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.include(req, resp);
    }
}

