package com.victorp.services;

import com.victorp.model.Client;
import com.victorp.model.Trainer;
import com.victorp.model.Workout;
import com.victorp.model.WorkoutPersonal;

public interface CreateWorkoutService {

    void createWorkoutPersonal(WorkoutPersonal workoutPersonal) throws Exception;
    void createWorkoutGroup(Trainer trainer, Workout workout, Client client) throws Exception;
    Client getByLogin(String login) throws Exception;
    Workout getByName(String name) throws Exception;
}
