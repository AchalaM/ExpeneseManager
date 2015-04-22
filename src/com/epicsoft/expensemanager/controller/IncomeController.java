/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.Income;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DHANUSHKA
 */
public class IncomeController {
    public static int addIncome(Income income,String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO Income VALUES ('" + income.getAccountName()+ "','" + income.getDate() + "','" + income.getAmount() +"','" +income.getCategory() +"','"+income.getPaymentMethod()+"','"+income.getDescription()+"')";
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql);    
    }
    
    public static int editIncome(int incIndex,Income income,String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE Income SET account_name="+income.getAccountName()+", incDate="+income.getDate()+", amount="+income.getAmount()+", category="+income.getCategory()+", paymentMethod="+income.getPaymentMethod()+", description="+income.getDescription() + "WHERE incIndex = " + incIndex; 
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql);
    }
    
    public static int deleteIncome(int incIndex,String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM Income WHERE incIndex = "+ incIndex;
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql); 
    }
}
