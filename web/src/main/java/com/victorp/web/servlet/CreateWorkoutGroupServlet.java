package com.victorp.web.servlet;

import com.victorp.model.Client;
import com.victorp.model.User;
import com.victorp.model.Workout;
import com.victorp.model.WorkoutGroup;
import com.victorp.services.CreateWorkoutService;
import com.victorp.services.impl.CreateWorkoutServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateWorkoutGroup", urlPatterns = "/createWorkoutGroup")
public class CreateWorkoutGroupServlet extends HttpServlet {

    public static final String NAME_WORKOUT = "nameGroup";
    private static final String DATE_TIME = "time";

    private final CreateWorkoutService createWorkoutService = CreateWorkoutServiceImpl.getInstance();

    final WorkoutGroup workoutGroup = new WorkoutGroup();
    final Workout workout = new Workout();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String nameWorkout = req.getParameter(NAME_WORKOUT);
        final String trainingTime = req.getParameter(DATE_TIME);

        try {
            workoutGroup.setWorkout(createWorkoutService.getByName(nameWorkout));
            workoutGroup.setTrainingTime(trainingTime);
            workoutGroup.setNameWorkout(nameWorkout);
            workout.setId(createWorkoutService.getByName(nameWorkout).getId());
            workout.setNameWorkout(createWorkoutService.getByName(nameWorkout).getNameWorkout());
            workout.setTrainer(createWorkoutService.getByName(nameWorkout).getTrainer());
            workout.setWorkoutGroup(workoutGroup);

            createWorkoutService.createWorkoutGroup(workoutGroup, workout);

        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=UTF-8");
        final RequestDispatcher dispatcher = req.getRequestDispatcher("trainerPage.jsp");
        dispatcher.include(req, resp);
    }
}
