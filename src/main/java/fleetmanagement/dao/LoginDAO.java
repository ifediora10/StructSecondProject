package fleetmanagement.dao;

import fleetmanagement.dbutil.HibernateUtil;
import fleetmanagement.pojo.LoginInfoPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    public static boolean isUserValid(LoginInfoPojo userDetails) {
        boolean validStatus = false;

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                // Use named parameters to prevent SQL injection
                String hql = "SELECT COUNT(*) FROM LoginInfoPojo WHERE username = :username AND password = :password";
                Query<Long> query = session.createQuery(hql, Long.class);
                query.setParameter("username", userDetails.getUsername());
                query.setParameter("password", userDetails.getPassword());

                Long count = query.uniqueResult();
                validStatus = count != null && count > 0;

                session.getTransaction().commit();
            }
        } catch (Exception e) {
            // Handle exceptions appropriately (log or throw a custom exception)
            e.printStackTrace();
        }

        return validStatus;
    }
}
