/*
 * Copyright 2015 Department of Computer Science and Engineering, University of Moratuwa.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *                  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lk.ac.mrt.cse.dbs.samples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class demonstrates the use of mysql-jdbc-connector driver to access a MySQL database.
 */
public class JDBCSample {
    private static final Logger log = LogManager.getLogger(JDBCSample.class);
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
            log.error("Unable to find the driver classes: ", e);
        } catch (SQLException e) {
            log.error("Unable to access the database server: ", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("Unable to close the database connection: ", e);
                }
            }
        }
    }
}
