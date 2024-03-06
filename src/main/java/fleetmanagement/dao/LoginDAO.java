package fleetmanagement.dao;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.LoginInfoPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LoginDAO {

//    public static boolean isUserValid(LoginInfo userDetails) {
//        boolean validStatus = false;
//
//        try {
//            Connection connection = DBUtil.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT *FROM login_info WHERE username = '" + userDetails.getUsername() + "' AND password = '" + userDetails.getPassword() + "'");
//
//            while (resultSet.next()) {
//                validStatus = true;
//            }
//            DBUtil.closeConnection(connection);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return validStatus;
//    }
private static final Logger log = LoggerFactory.getLogger(LoginDAO.class);

    public static boolean isUserValid(LoginInfoPojo userDetails) {
        boolean validStatus = false;
        Session session = null;
        Transaction transaction = null;

        try {
            // Get the session from the session factory
            session = HibernateUtil.getSessionFactory().openSession();

            // Begin a transaction
            transaction = session.beginTransaction();

            String hql = "SELECT COUNT(*) FROM LoginInfoPojo WHERE username = :username AND password = :password";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("username", userDetails.getUsername());
            query.setParameter("password", userDetails.getPassword());

            Long count = query.uniqueResult();
            validStatus = count != null && count > 0;

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // Rollback the transaction if an exception occurs
            if (transaction != null) {
                transaction.rollback();
            }
            // Log the exception for better debugging
            log.error("Error in isUserValid method", e);
        } finally {
            // Close the session in a finally block to ensure it's closed even if an exception occurs
            if (session != null) {
                session.close();
            }
        }

        return validStatus;
    }



//public static boolean isUserValid(LoginInfoPojo userDetails) {
//    boolean validStatus = false;
//
//    try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
//        try (Session session = sessionFactory.openSession()) {
//            // Begin a transaction
//            Transaction transaction = session.beginTransaction();
//
//            try {
//                // Use named parameters to prevent SQL injection
//                String hql = "SELECT COUNT(*) FROM LoginInfoPojo WHERE username = :username AND password = :password";
//                Query<Long> query = session.createQuery(hql, Long.class);
//                query.setParameter("username", userDetails.getUsername());
//                query.setParameter("password", userDetails.getPassword());
//
//                Long count = query.uniqueResult();
//                validStatus = count != null && count > 0;
//
//                // Commit the transaction if everything is successful
//                transaction.commit();
//            } catch (Exception e) {
//                // Rollback the transaction if an exception occurs
//                transaction.rollback();
//                // Log the exception or throw a custom exception without exposing sensitive information
//            }
//        }
//    } catch (Exception e) {
//        // Log the exception or throw a custom exception
//    }
//
//    return validStatus;
//}

}
