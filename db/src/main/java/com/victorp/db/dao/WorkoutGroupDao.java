package com.victorp.db.dao;

import com.victorp.model.WorkoutGroup;

public interface WorkoutGroupDao extends GeneralDao<WorkoutGroup> {

    WorkoutGroup getByNameWorkout(String nameWorkout) throws Exception;
}
