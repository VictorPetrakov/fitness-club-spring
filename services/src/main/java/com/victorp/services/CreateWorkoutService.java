package com.victorp.services;

import com.victorp.model.*;

public interface CreateWorkoutService {

    void createWorkoutPersonal(WorkoutPersonal workoutPersonal, Workout workout, Client client, User user) throws Exception;

    void createWorkoutGroup(WorkoutGroup workoutGroup, Workout workout) throws Exception;

    void addToWorkoutGroup(WorkoutGroup workoutGroup, Client client, Workout workout, User user) throws Exception;

    Client getByLogin(String login) throws Exception;

    Workout getByName(String name) throws Exception;

    WorkoutGroup getWorkoutGroupByName(String nameWorkout) throws Exception;

    User getUserByLogin(String login) throws Exception;
}
