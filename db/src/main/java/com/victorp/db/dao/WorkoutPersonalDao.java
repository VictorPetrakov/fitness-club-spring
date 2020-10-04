package com.victorp.db.dao;

import com.victorp.model.WorkoutPersonal;

public interface WorkoutPersonalDao extends GeneralDao<WorkoutPersonal>{

    WorkoutPersonal getByTrainer() throws Exception;
}
