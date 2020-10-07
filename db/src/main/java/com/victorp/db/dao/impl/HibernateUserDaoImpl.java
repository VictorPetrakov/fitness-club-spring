package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.UserDao;
import com.victorp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class HibernateUserDaoImpl implements UserDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public User getByLogin(String login) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("SELECT c FROM User c WHERE c.login = :login", User.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        }

    }

    @Override
    public User signUp(String login, String password) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("SELECT c FROM User c WHERE c.login = :login AND c.password = :password", User.class).setParameter("password", password).setParameter("login", login);
            return query.getSingleResult();
        } catch (NoResultException nre) {

        }
        return null;
    }


    @Override
    public User getById(Long id) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("SELECT c FROM User c WHERE c.id = :id", User.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<User> getAll() throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final NativeQuery<User> nativeQuery = session.createNativeQuery("SELECT * FROM user;", User.class);
            return nativeQuery.getResultList();
        }

    }

    @Override
    public void create(User user) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(User user) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.update(user);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Long id) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            final User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }

    }

    @Override
    public User checkUser(String login) {
        try (final Session session = sessionFactory.openSession()) {
            final Query<User> query = session.createQuery("SELECT c FROM User c WHERE c.login = :login", User.class).setParameter("login", login);
            return query.getSingleResult();
        } catch (NoResultException nre) {

        }
        return null;
    }

}
