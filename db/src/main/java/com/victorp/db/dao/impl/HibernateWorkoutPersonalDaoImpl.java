package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.WorkoutPersonalDao;
import com.victorp.model.User;
import com.victorp.model.WorkoutPersonal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateWorkoutPersonalDaoImpl implements WorkoutPersonalDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public WorkoutPersonal getByTrainer() throws Exception {
        return null;
    }

    @Override
    public WorkoutPersonal getById(Long id) throws Exception {
        try (final Session session = sessionFactory.openSession()){
            final Query<WorkoutPersonal> query = session.createQuery("SELECT c FROM WorkoutPersonal c WHERE c.id = :id", WorkoutPersonal.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<WorkoutPersonal> getAll() throws Exception {
        try (final Session session = sessionFactory.openSession()){
            final NativeQuery<WorkoutPersonal> nativeQuery = session.createNativeQuery("SELECT * FROM workoutpersonal;", WorkoutPersonal.class);
            return nativeQuery.getResultList();
        }
    }

    @Override
    public void create(WorkoutPersonal workoutPersonal) throws Exception {

        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.save(workoutPersonal);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(WorkoutPersonal workoutPersonal) throws Exception {

        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.update(workoutPersonal);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) throws Exception {

        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            final WorkoutPersonal workoutPersonal = session.get(WorkoutPersonal.class, id);
            session.delete(workoutPersonal);
            session.getTransaction().commit();
        }
    }
}
