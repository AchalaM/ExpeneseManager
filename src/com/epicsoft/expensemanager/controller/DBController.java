/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author hp
 */
public class DBController {
    
    public void addNewUser(User user){
        
    }
    
    /**
     * 
     * @param dbName
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void createDB(String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance(dbName + ";create=true", user, password).getConnection();
    }
    
    /**
     * 
     * @param dbName
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void createTables(String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String table_useraccount = "CREATE table user_account (" +
                "username varchar(50) NOT NULL," +
                "name varchar(20) NOT NULL," +
                "currencyType varchar(5)," +
                "PRIMARY KEY(username)" +
                ")";
                
        String table_account = "create table account(" +
                "account_number varchar(20) not null," +
                "name varchar(20) not null," +
                "transactions varchar(20) not null," +
                "Acctype varchar(20) not null," +
                "initial_balance int not null," +
                "PRIMARY KEY(account_number)" +
                ")";
                
        String table_incomeItem = "create table Income_item(" +
                "category varchar(20)," +
                "PRIMARY KEY(category)" +
                ")";
                
        String table_expenseItem = "create table Expense_item(" +
                "category varchar(20)," +
                "PRIMARY KEY(category)" +
                ")";
                
        String table_expenseCategories = "create table expense_categories (" +
                "category varchar(20) NOT NULL," +
                "sub_category varchar(20) NOT NULL," +
                "PRIMARY KEY(category, sub_category)," +
                "FOREIGN KEY(category) references expense_item(category)" +
                ")";
                
        String table_earn = "create table earn (" +
                "incIndex int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "account_name varchar(20)," +
                "incDate date," +
                "ammount int," +
                "category varchar(20)," +
                "paymentMethod varchar(10)," +
                "description varchar(50)," +
                "PRIMARY KEY(incIndex)," +
                "FOREIGN KEY(account_name) references account(account_number)," +
                "FoREIGN KEY(category) references income_item(category)" +
                ")";
                
        String table_expend = "create table expend (" +
                "expIndex int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                "account varchar(20)," +
                "expDate date," +
                "ammount int," +
                "category varchar(20)," +
                "paymentMethod varchar(10)," +
                "description varchar(50)," +
                "PRIMARY KEY(expIndex)," +
                "FOREIGN KEY(account) references account(account_number)," +
                "FOREIGN KEY(category) references expense_item(category)" +
                ")";
        
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement statement = connection.createStatement();
        
        statement.executeUpdate(table_useraccount);
        statement.executeUpdate(table_account);
        statement.executeUpdate(table_incomeItem);
        statement.executeUpdate(table_expenseItem);
        statement.executeUpdate(table_expenseCategories);
        statement.executeUpdate(table_earn);
        statement.executeUpdate(table_expend);

        System.out.println("Table created successfuly");
    }
    
    /**
     * 
     * @param dbName
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void insertDefaultValuesToTables(String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String incomeCategories = "insert into Income_item values ('Salary'),"
                + "('Personal Savings'),"
                + "('Part-time work'),"
                + "('Pensions'),"
                + "('Annuities')";
                
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement statement = connection.createStatement();
        
        statement.executeUpdate(incomeCategories);
        
        System.out.println("Default values added to tables");
    }
        
    public void dropDB(){
        
    }
    
}
