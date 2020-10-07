package com.victorp.db.dao.impl;

import com.victorp.db.HibernateUtil;
import com.victorp.db.dao.UserRoleDao;
import com.victorp.model.User;
import com.victorp.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class HibernateUserRoleDaoImpl implements UserRoleDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void create(UserRole userRole) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(userRole);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(UserRole userRole) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.update(userRole);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) throws Exception {

        try (final Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            final UserRole userRole = session.get(UserRole.class, id);
            session.delete(userRole);
            session.getTransaction().commit();
        }
    }

    @Override
    public boolean checkUserRole(String name) {

        UserRole userRole = null;
        try (final Session session = sessionFactory.openSession()) {
            final Query<UserRole> query = session.createQuery("SELECT c FROM UserRole c WHERE c.name = :name", UserRole.class).setParameter("name", name);
            userRole = query.getSingleResult();

        } catch (NoResultException nre) {

        }
        if (userRole != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserRole getUserRole(String name) {
        UserRole userRole;
        try (final Session session = sessionFactory.openSession()) {
            final Query<UserRole> query = session.createQuery("SELECT c FROM UserRole c WHERE c.name = :name", UserRole.class).setParameter("name", name);
            userRole = query.getSingleResult();
            return userRole;
        }
    }

    @Override
    public UserRole getById(Long id) throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final Query<UserRole> query = session.createQuery("SELECT c FROM UserRole c WHERE c.id = :id", UserRole.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    }

    @Override
    public List getAll() throws Exception {
        try (final Session session = sessionFactory.openSession()) {
            final NativeQuery<UserRole> nativeQuery = session.createNativeQuery("SELECT * FROM user_role;", UserRole.class);
            return nativeQuery.getResultList();
        }

    }

}
