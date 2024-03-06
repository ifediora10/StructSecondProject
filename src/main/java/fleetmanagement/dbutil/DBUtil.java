//package fleetmanagement.dbutil;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//
//public class DBUtil {
//
//    private static final String URL = "jdbc:postgresql://localhost:5431/strutsCRUD";
//    private static final String USER = "postgres";
//    private static final String PASSWORD = "password";
//
//    public static Connection getConnection() throws SQLException {
//        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            return DriverManager.getConnection(URL, USER, PASSWORD);
//
//        } catch (ClassNotFoundException e) {
//            throw new SQLException("PostgreSQL JDBC driver not found", e);
//        }
//    }
//
//    public static void closeConnection(Connection connection) {
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
