package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.WorkoutGroupDao;
import com.victorp.model.User;
import com.victorp.model.WorkoutGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateWorkoutGroupDaoImpl implements WorkoutGroupDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public WorkoutGroup getByNameWorkout(String nameWorkout) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<WorkoutGroup> query = session.createQuery("SELECT c FROM WorkoutGroup c WHERE c.nameWorkout = :nameWorkout", WorkoutGroup.class);
            query.setParameter("nameWorkout", nameWorkout);
            return query.getSingleResult();
        }
    }

    @Override
    public WorkoutGroup getById(Long id) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<WorkoutGroup> query = session.createQuery("SELECT c FROM WorkoutGroup c WHERE c.id = :id", WorkoutGroup.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<WorkoutGroup> getAll() throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final NativeQuery<WorkoutGroup> nativeQuery = session.createNativeQuery("SELECT * FROM workoutgroup;", WorkoutGroup.class);
            return nativeQuery.getResultList();
        }
    }

    @Override
    public void create(WorkoutGroup workoutGroup) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(workoutGroup);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(WorkoutGroup workoutGroup) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.update(workoutGroup);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            final WorkoutGroup workoutGroup = session.get(WorkoutGroup.class, id);
            session.delete(workoutGroup);
            session.getTransaction().commit();
        }
    }
}
