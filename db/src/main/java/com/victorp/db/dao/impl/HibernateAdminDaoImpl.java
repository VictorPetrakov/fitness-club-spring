package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.AdminDao;
import com.victorp.model.Admin;
import com.victorp.model.Client;
import com.victorp.model.User;
import com.victorp.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateAdminDaoImpl implements AdminDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Admin signUp(String login, String password) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<Admin> query = session.createQuery("SELECT c FROM User c WHERE c.login = :login AND c.password = :password"  , Admin.class);
            return query.getSingleResult();
        }
    }

    @Override
    public Admin getByLogin(String login) throws Exception {
        try (final Session session = sessionFactory.openSession()){
            final Query<Admin> query = session.createQuery("SELECT c FROM Admin c WHERE c.login = :login", Admin.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        }
    }

    @Override
    public Admin getById(Long id) throws Exception {
        try (final Session session = sessionFactory.openSession()){
            final Query<Admin> query = session.createQuery("SELECT c FROM Admin c WHERE c.id = :id", Admin.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List<Admin> getAll() throws Exception {
        try (final Session session = sessionFactory.openSession()){
            final NativeQuery<Admin> nativeQuery = session.createNativeQuery("SELECT * FROM admin;", Admin.class);
            return nativeQuery.getResultList();
        }
    }

    @Override
    public void create(Admin admin) throws Exception {
        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.save(admin);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Admin admin) throws Exception {
        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.update(admin);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) throws Exception {

        try (final Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            final Admin admin = session.get(Admin.class, id);
            session.delete(admin);
            session.getTransaction().commit();
        }
    }
}
