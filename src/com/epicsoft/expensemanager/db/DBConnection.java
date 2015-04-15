/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class DBConnection {
    
    private static DBConnection dBConnection;
    private Connection connection;
    
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_URL = "jdbc:derby:" + System.getProperty("user.home", ".") + "\\ExpenseManager\\db\\";
    
    /**
     * @param JDBC_URL
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    private DBConnection(String JDBC_URL, String user, String password) throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_URL + JDBC_URL, user, password);
    }
    
    /**
     * 
     * @param JDBC_URL
     * @param user
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static DBConnection getInstance(String JDBC_URL, String user, String password) throws ClassNotFoundException, SQLException{
        if (dBConnection == null) {
            dBConnection = new DBConnection(JDBC_URL, user, password);
        }
        return dBConnection;
    }
    
    /**
     * 
     * @param JDBC_URL
     * @param user
     * @param password
     * @return 
     */
    public Connection getConnection(){
        return connection;
    }
}
