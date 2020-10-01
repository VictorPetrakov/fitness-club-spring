package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.UserDao;
import com.victorp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class HibernateUserDaoImpl implements UserDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public User getByLogin(String login) throws Exception {
        return null;
    }

    @Override
    public User signUp(String login, String password) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("SELECT c FROM User c WHERE c.login = :login AND c.password = :password"  , User.class);
            return query.getSingleResult();
        }
    }

    @Override
    public User get(Long id) throws Exception {
        return null;
    }


    @Override
    public List<User> getAll() throws Exception {
        return null;
    }

    @Override
    public User getById(Long id) throws Exception {
        return null;
    }


    @Override
    public void create(User user) throws Exception {
        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(User item) throws Exception {

    }

    @Override
    public void delete(Long id) throws Exception {

    }

    @Override
    public User checkUser(String login) {
        User user;
        try (final Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("SELECT c FROM User c WHERE c.login = :login"  , User.class).setParameter("login", login);
            user = query.getSingleResult();
            return user;
        }catch (NoResultException nre){

        }
       return null;
    }
}
