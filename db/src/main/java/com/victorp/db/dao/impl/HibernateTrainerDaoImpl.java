package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.TrainerDao;
import com.victorp.model.Client;
import com.victorp.model.Trainer;
import com.victorp.model.User;
import com.victorp.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTrainerDaoImpl implements TrainerDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Trainer getByLogin(String login) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<Trainer> query = session.createQuery("SELECT c FROM Trainer c WHERE c.login = :login", Trainer.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        }
    }

    @Override
    public Trainer getByGroup(String group) throws Exception {
        return null;
    }

    @Override
    public Trainer getById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Trainer> getAll() throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final NativeQuery<Trainer> nativeQuery = session.createNativeQuery("SELECT * FROM trainer;", Trainer.class);
            return nativeQuery.getResultList();
        }
    }

    @Override
    public void create(Trainer trainer) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(trainer);
            session.getTransaction().commit();
        }
    }


    @Override
    public void update(Trainer trainer) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.update(trainer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            final Trainer trainer = session.get(Trainer.class, id);
            session.delete(trainer);
            session.getTransaction().commit();
        }
    }
}
