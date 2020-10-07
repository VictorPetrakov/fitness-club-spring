package com.victorp.services.impl;

import com.victorp.db.dao.impl.*;
import com.victorp.model.*;
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
    public void createWorkoutPersonal(WorkoutPersonal workoutPersonal, Workout workout, Client client, User user) throws Exception {
        HibernateWorkoutPersonalDaoImpl hibernateWorkoutPersonalDao = new HibernateWorkoutPersonalDaoImpl();
        HibernateWorkoutDaoImpl hibernateWorkoutDao = new HibernateWorkoutDaoImpl();
        HibernateClientDaoImpl hibernateClientDao = new HibernateClientDaoImpl();
        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        hibernateWorkoutPersonalDao.create(workoutPersonal);
        hibernateWorkoutDao.update(workout);
        hibernateClientDao.update(client);
        hibernateUserDao.update(user);
    }

    @Override
    public void createWorkoutGroup(WorkoutGroup workoutGroup, Workout workout) throws Exception {
        HibernateWorkoutGroupDaoImpl hibernateWorkoutGroupDao = new HibernateWorkoutGroupDaoImpl();
        HibernateWorkoutDaoImpl hibernateWorkoutDao = new HibernateWorkoutDaoImpl();
        hibernateWorkoutGroupDao.create(workoutGroup);
        hibernateWorkoutDao.update(workout);


    }

    @Override
    public void addToWorkoutGroup(WorkoutGroup workoutGroup, Client client, Workout workout, User user) throws Exception {
        HibernateWorkoutGroupDaoImpl hibernateWorkoutGroupDao = new HibernateWorkoutGroupDaoImpl();
        HibernateClientDaoImpl hibernateClientDao = new HibernateClientDaoImpl();
        HibernateWorkoutDaoImpl hibernateWorkoutDao = new HibernateWorkoutDaoImpl();
        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        hibernateWorkoutGroupDao.update(workoutGroup);
        hibernateClientDao.update(client);
        hibernateWorkoutDao.update(workout);
        hibernateUserDao.update(user);
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

    @Override
    public WorkoutGroup getWorkoutGroupByName(String nameWorkout) throws Exception {
        HibernateWorkoutGroupDaoImpl hibernateWorkoutGroupDao = new HibernateWorkoutGroupDaoImpl();
        return hibernateWorkoutGroupDao.getByNameWorkout(nameWorkout);
    }

    @Override
    public User getUserByLogin(String login) throws Exception {
        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        return hibernateUserDao.getByLogin(login);
    }
}
