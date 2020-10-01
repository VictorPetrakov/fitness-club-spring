package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.AdminDao;
import com.victorp.model.Admin;
import com.victorp.model.Client;
import com.victorp.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        return null;
    }

    @Override
    public Admin get(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Admin> getAll() throws Exception {
        return null;
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
    public void update(Admin item) throws Exception {

    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
