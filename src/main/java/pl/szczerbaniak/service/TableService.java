package pl.szczerbaniak.service;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;
import pl.szczerbaniak.model.Visitors;

import java.util.List;
import java.util.Properties;

@Service
public class TableService {

    public Object getAdminByUsername(String username) {
        Transaction tx = null;
        Session session = null;
        Object admin = null;

        try {
            session = configureSessionFactory().openSession();
            tx = session.beginTransaction();
            admin = session.createQuery("from Admins bdm where bdm.username = :username")
                    .setParameter("username", username).uniqueResult();
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error !!: " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return admin;
    }

    public Visitors addVisitor(Visitors visitor) {
        Transaction tx = null;
        Session session = null;

        try {
            session = configureSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(visitor);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error !!: " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return visitor;
    }

    public List<Visitors> getAllVisitors() {
        Transaction tx = null;
        Session session = null;
        List<Visitors> visitorsList = null;

        try {
            session = configureSessionFactory().openSession();
            tx = session.beginTransaction();
            visitorsList = session.createQuery("from Visitors").list();
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error !!: " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return visitorsList;
    }

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();
        Properties properties = configuration.getProperties();

        ServiceRegistry serviceRegistry;
        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

}
