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
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/ExpenseManager";
    
    /**
     * @param JDBC_URL
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(DB_URL, "root", "mrt");
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
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }
    
    /**
     * 
     * @return 
     */
    public Connection getConnection(){
        return connection;
    }
}
