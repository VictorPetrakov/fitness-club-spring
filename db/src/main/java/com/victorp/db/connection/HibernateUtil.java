package com.victorp.db.connection;

import com.victorp.model.Admin;
import com.victorp.model.Client;
import com.victorp.model.Trainer;
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
                            .buildSessionFactory();

                    try {
                        final Properties properties = new Properties();
                        final InputStream in = JdbcProvider.class.getClassLoader().getResourceAsStream("connection.properties");
                        properties.load(in);

                        new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Client.class)
                                .addAnnotatedClass(Admin.class)
                                .addAnnotatedClass(Trainer.class)
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

