package com.victorp.web.servlet;

import com.victorp.model.Trainer;
import com.victorp.model.User;
import com.victorp.model.UserRole;
import com.victorp.model.Workout;
import com.victorp.services.RegistrationService;
import com.victorp.services.impl.RegistrationServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegistrationServletTrainers", urlPatterns = "/registTrainers")

public class RegistrationServletTrainers extends HttpServlet {

    public static final String LOGIN_PARAM = "login";
    public static final String PASSWORD_PARAM = "password";
    public static final String FIRSTNAME_PARAM = "firstname";
    public static final String LASTNAME_PARAM = "lastname";
    public static final String BIRTHDATE_PARAM = "birthdate";
    public static final String EMAIL_PARAM = "email";
    public static final String GROUP = "group";

    private final RegistrationService registrationService = RegistrationServiceImpl.getInstance();

    final User user = new User();
    final Trainer trainer = new Trainer();
    final UserRole userRole = new UserRole();
    final Workout workout = new Workout();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String login = req.getParameter(LOGIN_PARAM);
        final String password = req.getParameter(PASSWORD_PARAM);
        final String firstname = req.getParameter(FIRSTNAME_PARAM);
        final String lastname = req.getParameter(LASTNAME_PARAM);
        final String birthdate = req.getParameter(BIRTHDATE_PARAM);
        final String email = req.getParameter(EMAIL_PARAM);
        final String group = req.getParameter(GROUP);

        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setBirthdate(birthdate);
        user.setEmail(email);

        try {
            if(registrationService.checkUser(login) == null){
                if (registrationService.checkUserRole("trainer") == false) {
                    userRole.setName("trainer");
                    userRole.setAdmin(false);
                    userRole.setTrainer(true);
                    userRole.addUser(user);
                    user.setUserRole(userRole);

                }else{

                    UserRole foundUserRole2;
                    foundUserRole2 = registrationService.getUserRole("trainer");
                    userRole.setName(foundUserRole2.getName());
                    userRole.setAdmin(foundUserRole2.getAdmin());
                    userRole.setTrainer(foundUserRole2.getTrainer());
                    userRole.setId(foundUserRole2.getId());
                    userRole.setUsers(foundUserRole2.getUsers());
                    userRole.addUser(user);
                    user.setUserRole(userRole);

                }

                trainer.setUser(user);
                trainer.setLogin(login);
                trainer.setTrainerIdentifier((long)(Math.random()*20000 - 0));

                workout.setNameWorkout(group);
                workout.setTrainer(trainer);

                registrationService.createTrainer(trainer, user, userRole, workout);

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

