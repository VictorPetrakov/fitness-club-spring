package com.victorp.db.connection;

import org.junit.Test;

import javax.persistence.EntityManager;

public class HibernateUtilTest {
    @Test
    public void test() {
    final EntityManager entityManager = HibernateUtil.getEntityManager();

    }
}
