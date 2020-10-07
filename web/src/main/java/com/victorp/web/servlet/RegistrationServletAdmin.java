package com.victorp.web.servlet;

import com.victorp.model.Admin;
import com.victorp.model.User;
import com.victorp.model.UserRole;
import com.victorp.services.RegistrationService;
import com.victorp.services.impl.RegistrationServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegistrationServletAdmin", urlPatterns = "/registAdmin")

public class RegistrationServletAdmin extends HttpServlet {

    public static final String LOGIN_PARAM = "login";
    public static final String PASSWORD_PARAM = "password";
    public static final String FIRSTNAME_PARAM = "firstname";
    public static final String LASTNAME_PARAM = "lastname";
    public static final String BIRTHDATE_PARAM = "birthdate";
    public static final String EMAIL_PARAM = "email";

    private final RegistrationService registrationService = RegistrationServiceImpl.getInstance();

    final User user = new User();
    final Admin admin = new Admin();
    final UserRole userRole = new UserRole();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        final String login = req.getParameter(LOGIN_PARAM);
        final String password = req.getParameter(PASSWORD_PARAM);
        final String firstname = req.getParameter(FIRSTNAME_PARAM);
        final String lastname = req.getParameter(LASTNAME_PARAM);
        final String birthdate = req.getParameter(BIRTHDATE_PARAM);
        final String email = req.getParameter(EMAIL_PARAM);

        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setBirthdate(birthdate);
        user.setEmail(email);

        try {
            if (registrationService.checkUser(login) == null) {
                if (registrationService.checkUserRole("admin") == false) {
                    userRole.setName("admin");
                    userRole.setAdmin(true);
                    userRole.setTrainer(false);
                    userRole.addUser(user);
                    user.setUserRole(userRole);

                } else {

                    UserRole foundUserRole1;
                    foundUserRole1 = registrationService.getUserRole("admin");
                    userRole.setName(foundUserRole1.getName());
                    userRole.setAdmin(foundUserRole1.getAdmin());
                    userRole.setTrainer((foundUserRole1.getTrainer()));
                    userRole.setId(foundUserRole1.getId());
                    userRole.setUsers(foundUserRole1.getUsers());
                    userRole.addUser(user);
                    user.setUserRole(userRole);

                }

                admin.setUser(user);
                admin.setLogin(login);
                admin.setAdminIdentifier((long) (Math.random() * 20000 - 0));

                registrationService.createAdmin(admin, user, userRole);

            } else {

                resp.setContentType("text/html;charset=UTF-8");
                final RequestDispatcher dispatcher = req.getRequestDispatcher("/webapp/errors/401.jsp");
                dispatcher.include(req, resp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=UTF-8");
        final RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.include(req, resp);
    }


}

