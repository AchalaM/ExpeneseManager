/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.Account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author hp
 */
public class AccountController {
    
    /**
     * Add a new account.
     * @param account
     */
    public void addNewAccount(Account account) throws ClassNotFoundException, SQLException {
        String name = account.getAccountName();
        String accType = account.getAccountType();
        double initialBalance = account.getInitialBalance();
        double currentBalance = account.getCurrentBalance();
        
        String sql = "Insert into account values (\""+name+"\",\""+accType+"\",\""+initialBalance+"\",\""+currentBalance+"\")";
        
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        
        statement.executeUpdate(sql);
        
    }
    
    /**
     * Edit account details.
     * @param accName
     * @param account
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void editAccount(String accName, Account account) throws ClassNotFoundException, SQLException {
        String name = account.getAccountName();
        String accType = account.getAccountType();
        double initialBalance = account.getInitialBalance();
        double currentBalance = account.getCurrentBalance();
        
        String sql = "Update account set name = \""+name+"\", acctype = \""+accType+"\", initialBalance = \""+initialBalance+"\" where name = \""+accName+"\"";
        
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        
        statement.executeUpdate(sql);
    }
    
    /**
     * Update the current balance in account table.
     * @param accName
     * @param currentBalance
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void editCurrentBalance(String accName, double currentBalance) throws ClassNotFoundException, SQLException {
        String sql = "Update account set currentBalance = \""+currentBalance+"\" where name = \""+accName+"\"";
        
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        
        statement.executeUpdate(sql);
    }
    
    /**
     * Delete an account from the database.
     * @param name
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void deleteAccount(String name) throws ClassNotFoundException, SQLException {
        String sql = "delete from account where name = \""+name+"\"";
        
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        
        statement.executeUpdate(sql);
    }
    
    /**
     * Get all account details from the database.
     * @return List accounts as a ArrayList.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public List<Account> getAllAccounts() throws ClassNotFoundException, SQLException {
        String sql = "Select * from account";
        List<Account> accountList = new ArrayList<>();
        
        Connection connection = DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        
        ResultSet result = statement.executeQuery(sql);
        
        while (result.next()) {
            String name = result.getString("name");
            String accType = result.getString("AccType");
            double iniBal = result.getDouble("initialBalance");
            double curBal = result.getDouble("currentBalance");
            
            Account account = new Account(name, accType, iniBal, curBal);
            
            accountList.add(account);
        }
        
        return accountList;
    }
}
