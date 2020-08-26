package com.victorp.db.connection;

import com.victorp.model.Client;
import org.hibernate.Session;
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
        try(final Session session = sessionFactory.openSession()){

            session.getTransaction().begin();
            final Client client = new Client("login", "passw", "firstName","lastName", "20.02.1992","email", "fitness");
            session.persist(client);
            session.getTransaction().commit();
        }
        HibernateUtil.closeSF();

    }
}
