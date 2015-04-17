/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.PaymentMethod;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DHANUSHKA
 */
public class PaymentMethodController {
    public static List<PaymentMethod> getAllPaymentMethods(String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Payment_Method";
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        
        List<PaymentMethod> paymentMethodList = new ArrayList<>();
        
        while(rst.next()){
            String method = rst.getString("Method");
            
            PaymentMethod paymentMethod = new PaymentMethod(method);
            paymentMethodList.add(paymentMethod);
        }
        return paymentMethodList;
    }
    
    public static int addPaymentMethod(PaymentMethod method,String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO Payment_Method values('"+method.getPaymentMethod()+"')";
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql);
    }
    
    public static int removePaymentMethod(PaymentMethod method,String dbName, String user, String password) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM Payment_Method where Method =" + method.getPaymentMethod();
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql);
    }
    
}
