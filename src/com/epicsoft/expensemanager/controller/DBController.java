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
    public void createDB() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
    }
    
    /**
     * 
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void createTables() throws ClassNotFoundException, SQLException{
        String table_useraccount = "CREATE table user_account (" +
                "username varchar(50) NOT NULL," +
                "name varchar(20) NOT NULL," +
                "currencyType varchar(5) DEFAULT 'LKR'," +
                "currencySymbol varchar(2) DEFAULT 'Rs'," +
                "PRIMARY KEY(username)" +
                ")";
                
        String table_account = "create table account(" +
                "account_number varchar(20) not null," +
                "name varchar(20) not null," +
                "transactions varchar(20) not null," +
                "Acctype varchar(20) not null," +
                "initial_balance int not null," +
                "CHECK (initial_balance>0)," +
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
                "incIndex int NOT NULL AUTO_INCREMENT," +
                "account_name varchar(20)," +
                "incDate date," +
                "ammount int DEFAULT 0," +
                "category varchar(20)," +
                "paymentMethod varchar(10)," +
                "description varchar(50)," +
                "CHECK (amount>=0)," +
                "PRIMARY KEY(incIndex)," +
                "FOREIGN KEY(account_name) references account(account_number)," +
                "FoREIGN KEY(category) references income_item(category)" +
                ")";
                
        String table_expend = "create table expend (" +
                "expIndex int NOT NULL AUTO_INCREMENT," +
                "account varchar(20)," +
                "expDate date," +
                "ammount int DEFAULT 0," +
                "category varchar(20)," +
                "paymentMethod varchar(10)," +
                "description varchar(50)," +
                "CHECK (amount>=0)," +
                "PRIMARY KEY(expIndex)," +
                "FOREIGN KEY(account) references account(account_number)," +
                "FOREIGN KEY(category) references expense_item(category)" +
                ")";
        
        String table_paymentMethod = "create table Payment_Method (" +
                "paymentMethod varchar(20)," +
                "PRIMARY KEY(paymentMethod)" +
                ")";
        
        String table_currency = "create table currency (" +
                "currencyType varchar(5) NOT NULL," +
                "symbol varchar(3)," +
                "PRIMARY KEY(currencyType)" +
                ");";
        
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        
        statement.executeUpdate(table_useraccount);
        statement.executeUpdate(table_account);
        statement.executeUpdate(table_incomeItem);
        statement.executeUpdate(table_expenseItem);
        statement.executeUpdate(table_expenseCategories);
        statement.executeUpdate(table_earn);
        statement.executeUpdate(table_expend);
        statement.executeUpdate(table_paymentMethod);
        statement.executeUpdate(table_currency);
        
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
                
        String paymentMethods = "insert into Payment_Method values ('Cash'),"
                + "('Checque'),"
                + "('Loan')";
        
        String expenseItems = "insert into Expense_item values ('Automobile'),"
                + "('Entertainment'),"
                + "('Food'),"
                + "('Health Care'),"
                + "('Insurance'),"
                + "('Other'),"
                + "('Personal'),"
                + "('Travel'),"
                + "('Bills')";
        
        String expenseCategories = "insert into expense_categories values('Automobile','Fuel'),"
                + "('Automobile','Maintenence'),"
                + "('Automobile','Registration'),"
                + "('Automobile','Repairs'),"
                + "('Automobile','Other'),"
                + "('Entertainment','Concert'),"
                + "('Entertainment','Drama'),"
                + "('Entertainment','Movies'),"
                + "('Entertainment','Other'),"
                + "('Entertainment','Party'),"
                + "('Food','Breakfast'),"
                + "('Food','Dinner'),"
                + "('Food','Groceries'),"
                + "('Food','Lunch'),"
                + "('Food','Other'),"
                + "('Food','Snacks'),"
                + "('Food','Soft Drinks'),"
                + "('Health care','Dental'),"
                + "('Health care','Eye Care'),"
                + "('Health care','Medical'),"
                + "('Health care','Other'),"
                + "('Health care','Prescription'),"
                + "('Insurance','Automobile'),"
                + "('Insurance','Health'),"
                + "('Insurance','Home'),"
                + "('Insurance','Life'),"
                + "('Insurance','Other'),"
                + "('Other','other'),"
                + "('Personal','Clothing'),"
                + "('Personal','Donation'),"
                + "('Personal','Gifts'),"
                + "('Personal','Other'),"
                + "('Personal','Personal Care'),"
                + "('Travel','Air Plane'),"
                + "('Travel','Bus'),"
                + "('Travel','Other'),"
                + "('Travel','Taxi'),"
                + "('Travel','Train'),"
                + "('Bills','Electricity'),"
                + "('Bills','Internet'),"
                + "('Bills','Mobile Phone'),"
                + "('Bills','Telephone'),"
                + "('Bills','Television'),"
                + "('Bills','Water')";
                
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        
        //statement.executeUpdate(incomeCategories);
        //statement.executeUpdate(paymentMethods);
        //statement.executeUpdate(expenseItems);
        statement.executeUpdate(expenseCategories);
        
        System.out.println("Default values added to tables");
    }
        
    public void dropDB(){
        
    }
    
}
