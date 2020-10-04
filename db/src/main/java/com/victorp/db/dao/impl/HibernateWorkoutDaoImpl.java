package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.WorkoutDao;
import com.victorp.model.Workout;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateWorkoutDaoImpl implements WorkoutDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Workout getByName(String nameWorkout) throws Exception {
        try (final Session session = sessionFactory.openSession()){
            final Query<Workout> query = session.createQuery("SELECT c FROM Workout c WHERE c.nameWorkout = :nameWorkout", Workout.class);
            query.setParameter("nameWorkout", nameWorkout);
            return query.getSingleResult();
        }
    }

    @Override
    public Workout getById(Long id) throws Exception {
        try (final Session session = sessionFactory.openSession()){
            final Query<Workout> query = session.createQuery("SELECT c FROM Workout c WHERE c.id = :id", Workout.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<Workout> getAll() throws Exception {
        try (final Session session = sessionFactory.openSession()){
            final NativeQuery<Workout> nativeQuery = session.createNativeQuery("SELECT * FROM workout;", Workout.class);
            return nativeQuery.getResultList();
        }
    }

    @Override
    public void create(Workout workout) throws Exception {

        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.save(workout);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Workout workout) throws Exception {

        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.update(workout);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) throws Exception {

        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            final Workout workout = session.get(Workout.class, id);
            session.delete(workout);
            session.getTransaction().commit();
        }
    }
}
