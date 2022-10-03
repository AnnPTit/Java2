/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasoft203_re.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DbContext {

    private static String url = String.format("jdbc:sqlserver://JAVA\\SQLEXPRESS:1433;"
            + "databaseName =DEMO;user=sa;password=123456;");
    private static boolean ussingSSL = true;

    static {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            if (ussingSSL) {
                url += "encrypt=true;trustServerCertificate=true;";
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

}
