package pl.szczerbaniak.service;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;
import pl.szczerbaniak.model.Admins;
import pl.szczerbaniak.model.Visitors;

import java.util.List;
import java.util.Properties;

@Service
public class TableService {

    public void deleteAdmin() {
        Transaction tx = null;
        Session session = null;

        try {
            session = configureSessionFactory().openSession();
            tx = session.beginTransaction();
            session.createQuery("DELETE from Admins dbm where dbm.username = 'admin'").executeUpdate();
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
//        return adminsList;
    }

    public List<Admins> getAllAdmins() {
        Transaction tx = null;
        Session session = null;
        List<Admins> adminsList = null;

        try {
            session = configureSessionFactory().openSession();
            tx = session.beginTransaction();
            adminsList = session.createQuery("from Admins").list();
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
        return adminsList;
    }

    public Admins addAdmin(Admins newAdmin) {
        Transaction tx = null;
        Session session = null;


        try {
            session = configureSessionFactory().openSession();
            tx = session.beginTransaction();
            Long countOfAdminsWithSameUsername = (Long) session.createQuery("select count(e) from Admins e where e.username = :username").setParameter("username", newAdmin.getUsername()).uniqueResult();
            if (countOfAdminsWithSameUsername > 0) {
                throw new IllegalArgumentException("admin with that username already exists");
            }
            session.save(newAdmin);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error !!: " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            throw new IllegalArgumentException("admin with that username already exists");

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return newAdmin;
    }

    public String getAdminPass(String username) {
        Transaction tx = null;
        Session session = null;
        String admin = null;

        try {
            session = configureSessionFactory().openSession();
            tx = session.beginTransaction();
            admin = (String) session.createQuery("select password from Admins bdm where bdm.username = :username")
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
