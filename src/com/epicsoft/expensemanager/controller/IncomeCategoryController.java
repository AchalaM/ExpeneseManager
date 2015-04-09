/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.IncomeCategory;
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
public class IncomeCategoryController {
    
    public List<IncomeCategory> getAllIncomeCategory(String dbName, String user, String password ) throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Income_item";
        Connection connection = DBConnection.getInstance(dbName, user, password).getConnection();
        Statement stm = connection.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        
        List<IncomeCategory> incomeCategoryList = new ArrayList<>();
        
        while(rst.next()){
            String category = rst.getString("category");
            
            IncomeCategory incomeCategory = new IncomeCategory(category);
            incomeCategoryList.add(incomeCategory);
        }
        return incomeCategoryList;
    }
}
