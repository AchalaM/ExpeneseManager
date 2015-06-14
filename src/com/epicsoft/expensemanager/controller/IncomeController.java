/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.Income;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DHANUSHKA
 */
public class IncomeController {
    public static List<Income> getAllIncomes(String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "Select * from earn order by incDate DESC";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        
        List<Income> incomeList = new ArrayList<>();
        
        while(rst.next()){
            String incomeID = rst.getString("incIndex");
            String account = rst.getString("account_name");
            Date date = rst.getDate("incDate");
            Double amount = Double.parseDouble(rst.getString("amount"));
            String category = rst.getString("category");
            String paymentMethod = rst.getString("paymentMethod");
            String description = rst.getString("description");
            
            Income income = new Income(account, date, category, amount, paymentMethod, description);
            incomeList.add(income);
        }
        return incomeList;
    }
    public static int addIncome(Income income,String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        //Account controller should be added and account name should be from it
        String sql = "INSERT INTO earn(account_name,incDate,amount,category,paymentMethod,description)"
                + " VALUES ('"+ "cash"+ "','" + income.getDate() + "','" + income.getAmount() +"','" +income.getCategory() +"','"+income.getPaymentMethod()+"','"+income.getDescription()+"')";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql);    
    }
    
    public static int editIncome(int incIndex,Income income,String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE earn SET account_name="+income.getAccountName()+", incDate="+income.getDate()+", amount="+income.getAmount()+", category="+income.getCategory()+", paymentMethod="+income.getPaymentMethod()+", description="+income.getDescription() + "WHERE incIndex = " + incIndex; 
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql);
    }
    
    public static int deleteIncome(int incIndex,String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM earn WHERE incIndex = "+ incIndex;
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql); 
    }
    
    public static String getLastIncomeID(String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "Select * from earn";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String id = "I000";
        while(rst.next()){
            id = rst.getString("incID"); 
        }
        return id;
    }
    
    public static List<Income> runQuery(String dbName, String user, String password,String request) throws ClassNotFoundException, SQLException{
        String sql = request;
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        
        List<Income> incomeList = new ArrayList<>();
        
        while(rst.next()){
            String incomeID = rst.getString("incIndex");
            String account = rst.getString("account_name");
            Date date = rst.getDate("incDate");
            Double amount = Double.parseDouble(rst.getString("amount"));
            String category = rst.getString("category");
            String paymentMethod = rst.getString("paymentMethod");
            String description = rst.getString("description");
            
            Income income = new Income(account, date, category, amount, paymentMethod, description);
            incomeList.add(income);
        }
        return incomeList;
    }
}
