package com.victorp.db;

import com.victorp.model.Client;
import com.victorp.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {

    private static EntityManagerFactory emf;

    private static SessionFactory sessionFactory;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("com.victorp.db");
        }
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateUtil.class) {
                if (sessionFactory == null) {
                    sessionFactory = new Configuration()
                            .configure()
                            .buildSessionFactory()
                    ;

                    try {
                        final Properties properties = new Properties();
                        final InputStream in = JdbcProvider.class.getClassLoader().getResourceAsStream("connection.properties");
                        properties.load(in);

                        new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(User.class)
                                .addProperties(properties)
                                .buildSessionFactory();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        return sessionFactory;
    }

    public static void closeSF() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

