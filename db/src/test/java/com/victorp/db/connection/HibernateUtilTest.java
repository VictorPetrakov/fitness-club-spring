package com.victorp.db.connection;

import org.hibernate.SessionFactory;
import org.junit.Test;

import javax.persistence.EntityManager;

public class HibernateUtilTest {
    @Test
    public void test() {
    final EntityManager entityManager = HibernateUtil.getEntityManager();

    }
    @Test
    public void testSessionFactory(){
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        HibernateUtil.close();

    }
}
