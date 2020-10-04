package com.victorp.db.dao;

import com.victorp.model.Workout;

public interface WorkoutDao extends GeneralDao<Workout> {

    Workout getByName(String nameWorkout) throws Exception;
}
