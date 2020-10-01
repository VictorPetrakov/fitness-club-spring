package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.TrainerDao;
import com.victorp.model.Client;
import com.victorp.model.Trainer;
import com.victorp.model.User;
import com.victorp.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HibernateTrainerDaoImpl implements TrainerDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Trainer signUp(String login, String password) throws Exception {
        return null;
    }

    @Override
    public Trainer getByLogin(String login) throws Exception {
        return null;
    }

    @Override
    public Trainer getByGroup(String group) throws Exception {
        return null;
    }

    @Override
    public Trainer get(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Trainer> getAll() throws Exception {
        return null;
    }

    @Override
    public void create(Trainer trainer) throws Exception {

        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.save(trainer);
            session.getTransaction().commit();
        }
    }


    @Override
    public void update(Trainer item) throws Exception {

    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
