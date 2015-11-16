package lk.ac.mrt.cse.dbs.samples;

import java.sql.*;

/**
 * This class demonstrates the use of mysql-jdbc-connector driver to access a MySQL database.
 */
public class JDBCSample {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs_tryit", "root", "");
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
