package com.victorp.web.servlet;

import com.victorp.model.WorkoutPersonal;
import com.victorp.services.CreateWorkoutService;
import com.victorp.services.impl.CreateWorkoutServiceImpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateWorkoutPersonal", urlPatterns = "/createWorkoutPersonal")
public class CreateWorkoutPersonalServlet extends HttpServlet {

    public static final String LOGIN_PARAM = "loginClient";
    public static final String NAME_WORKOUT = "group";
    private static final String DATE_TIME = "time";

    private final CreateWorkoutService createWorkoutService = CreateWorkoutServiceImpl.getInstance();

    final WorkoutPersonal workoutPersonal = new WorkoutPersonal();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String loginClient = req.getParameter(LOGIN_PARAM);
        final String nameWorkout = req.getParameter(NAME_WORKOUT);
        final String trainingTime = req.getParameter(DATE_TIME);

        try {
            workoutPersonal.setClient(createWorkoutService.getByLogin(loginClient));
            workoutPersonal.setWorkout(createWorkoutService.getByName(nameWorkout));
            workoutPersonal.setTrainingTime(trainingTime);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            createWorkoutService.createWorkoutPersonal(workoutPersonal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html;charset=UTF-8");
        final RequestDispatcher dispatcher = req.getRequestDispatcher("administration.jsp");
        dispatcher.include(req, resp);


    }
}
