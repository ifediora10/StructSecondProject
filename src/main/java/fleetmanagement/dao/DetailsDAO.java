package fleetmanagement.dao;

import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.DetailsPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DetailsDAO {
//    private static final SessionFactory sessionFactory;
//
//    static {
//        try {
//            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactory = new Configuration().configure("hibernate.cfg.xmk").buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

//    public void saveDetails(DetailsPojo detailsPojo) {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//
//            // Save DetailsPojo entity
//            session.save(detailsPojo);
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }


//    public void saveDetails(DetailsPojo details) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.save(details);
//            session.getTransaction().commit();
//        }
//    }

    public void saveDetails(DetailsPojo details) {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(details);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
