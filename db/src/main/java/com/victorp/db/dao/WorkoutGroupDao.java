package com.victorp.db.dao;

import com.victorp.model.WorkoutGroup;

public interface WorkoutGroupDao extends GeneralDao<WorkoutGroup> {

    WorkoutGroupDao getByTrainer() throws Exception;
}
