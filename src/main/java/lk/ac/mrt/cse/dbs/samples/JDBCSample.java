package lk.ac.mrt.cse.dbs.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class demonstrates the use of mysql-jdbc-connector driver to access a MySQL database.
 */
public class JDBCSample {
    private static final String MYSQL_JDBC_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String MYSQL_DATABASE_URL = "jdbc:mysql://localhost:3306/dbs_tryit";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName(MYSQL_JDBC_DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(MYSQL_DATABASE_URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Unable to find the driver classes: " + e.getLocalizedMessage());
        } catch (SQLException e) {
            System.err.println("Unable to access the database server: " + e.getLocalizedMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Unable to close the database connection: " + e.getLocalizedMessage());
                }
            }
        }
    }
}
