package com.victorp.db;

import org.junit.Test;

public class HibernateTest {
    @Test
    public void initHibernate2() {
        HibernateUtil.getSessionFactory().close();
    }

}
