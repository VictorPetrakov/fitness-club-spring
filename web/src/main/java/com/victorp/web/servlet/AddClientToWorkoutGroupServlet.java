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

@WebServlet(name = "AddClientToWorkoutGroup", urlPatterns = "/addClientToWorkoutGroup")
public class AddClientToWorkoutGroupServlet extends HttpServlet {

    public static final String LOGIN_PARAM = "loginClient";
    public static final String NAME_WORKOUT = "nameGroup";

    private final CreateWorkoutService createWorkoutService = CreateWorkoutServiceImpl.getInstance();

    final WorkoutGroup workoutGroup = new WorkoutGroup();
    final Workout workout = new Workout();
    final Client client = new Client();
    final User user = new User();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String loginClient = req.getParameter(LOGIN_PARAM);
        final String nameWorkout = req.getParameter(NAME_WORKOUT);

        WorkoutGroup foundWorkoutGroup;
        Workout foundWorkout;
        Client foundClient;
        User foundUser;

        try {

            foundWorkoutGroup = createWorkoutService.getWorkoutGroupByName(nameWorkout);

            workoutGroup.setId(foundWorkoutGroup.getId());
            workoutGroup.setNameWorkout(foundWorkoutGroup.getNameWorkout());
            workoutGroup.setTrainingTime(foundWorkoutGroup.getTrainingTime());
            workoutGroup.setClientList(foundWorkoutGroup.getClientList());
            workoutGroup.setWorkout(foundWorkoutGroup.getWorkout());
            workoutGroup.setClientToGroup(createWorkoutService.getByLogin(loginClient));

            foundWorkout = createWorkoutService.getByName(nameWorkout);

            workout.setId(foundWorkout.getId());
            workout.setTrainer(foundWorkout.getTrainer());
            workout.setNameWorkout(foundWorkout.getNameWorkout());
            workout.setWorkoutGroup(workoutGroup);
            workout.setWorkoutPersonalList(foundWorkout.getWorkoutPersonalList());

            foundClient = createWorkoutService.getByLogin(loginClient);

            client.setId(foundClient.getId());
            client.setLogin(foundClient.getLogin());
            client.setClientIdentifier(foundClient.getClientIdentifier());
            client.setUser(foundClient.getUser());
            client.setWorkoutGroup(workoutGroup);
            client.setNameGroup(workoutGroup.getNameWorkout());

            foundUser = createWorkoutService.getUserByLogin(loginClient);
            user.setId(foundUser.getId());
            user.setLogin(foundUser.getLogin());
            user.setPassword(foundUser.getPassword());
            user.setFirstName(foundUser.getFirstName());
            user.setLastName(foundUser.getLastName());
            user.setEmail(foundUser.getEmail());
            user.setBirthdate(foundUser.getBirthdate());
            user.setGroup(nameWorkout);
            user.setClient(foundUser.getClient());
            user.setUserRole(foundUser.getUserRole());


            createWorkoutService.addToWorkoutGroup(workoutGroup, client, workout, user);


        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html;charset=UTF-8");
        final RequestDispatcher dispatcher = req.getRequestDispatcher("trainerPage.jsp");
        dispatcher.include(req, resp);
    }


}
