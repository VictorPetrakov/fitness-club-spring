package com.victorp.services.impl;

import com.victorp.db.dao.impl.HibernateClientDaoImpl;
import com.victorp.db.dao.impl.HibernateWorkoutDaoImpl;
import com.victorp.db.dao.impl.HibernateWorkoutPersonalDaoImpl;
import com.victorp.model.Client;
import com.victorp.model.Trainer;
import com.victorp.model.Workout;
import com.victorp.model.WorkoutPersonal;
import com.victorp.services.CreateWorkoutService;

public class CreateWorkoutServiceImpl implements CreateWorkoutService {

    private static CreateWorkoutService instance;

    public static CreateWorkoutService getInstance() {

        if (instance == null) {
            synchronized (CreateWorkoutService.class) {
                if (instance == null) {
                    instance = new CreateWorkoutServiceImpl();
                }
            }
        }
        return instance;
    }

    private CreateWorkoutServiceImpl() {
    }
    @Override
    public void createWorkoutPersonal(WorkoutPersonal workoutPersonal) throws Exception {
        HibernateWorkoutPersonalDaoImpl hibernateWorkoutPersonalDao = new HibernateWorkoutPersonalDaoImpl();
        hibernateWorkoutPersonalDao.create(workoutPersonal);
    }

    @Override
    public void createWorkoutGroup(Trainer trainer, Workout workout, Client client) throws Exception {

    }

    @Override
    public Client getByLogin(String login) throws Exception {
        HibernateClientDaoImpl hibernateClientDao = new HibernateClientDaoImpl();
        return hibernateClientDao.getByLogin(login);
    }

    @Override
    public Workout getByName(String name) throws Exception {
        HibernateWorkoutDaoImpl hibernateWorkoutDao = new HibernateWorkoutDaoImpl();
        return hibernateWorkoutDao.getByName(name);
    }
}
