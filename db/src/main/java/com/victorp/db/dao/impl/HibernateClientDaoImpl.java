package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.ClientDao;
import com.victorp.model.Client;
import com.victorp.model.User;
import com.victorp.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class HibernateClientDaoImpl implements ClientDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void create(Client client) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Client client) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.update(client);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Long id) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            final Client client = session.get(Client.class, id);
            session.delete(client);
            session.getTransaction().commit();
        }

    }

    @Override
    public Client getByLogin(String login) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<Client> query = session.createQuery("SELECT c FROM Client c WHERE c.login = :login", Client.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        }

    }

    @Override
    public Client signUp(String login, String password) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<Client> query = session.createQuery("SELECT c FROM User c WHERE c.login = :login AND c.password = :password", Client.class);
            return query.getSingleResult();
        }
    }


    @Override
    public Client getById(Long id) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<Client> query = session.createQuery("SELECT c FROM Client c WHERE c.id = :id", Client.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<Client> getAll() throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final NativeQuery<Client> nativeQuery = session.createNativeQuery("SELECT * FROM client;", Client.class);
            return nativeQuery.getResultList();
        }

    }

    @Override
    public boolean checkClient(String login) {
        Client client = null;
        try (final Session session = sessionFactory.openSession()) {
            final Query<Client> query = session.createQuery("SELECT c FROM Client c WHERE c.login = :login", Client.class).setParameter("login", login);
            client = query.getSingleResult();

        } catch (NoResultException nre) {

        }
        if (client != null) {
            return true;
        } else {
            return false;
        }

    }
}
