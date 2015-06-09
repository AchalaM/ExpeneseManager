/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;


import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.ExpenseItem;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.Expend;
import com.epicsoft.expensemanager.model.ExpenseCatergory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SUPUN MADUSHANKA
 */
public class ExpenseCategoryController {

    
    public List<ExpenseItem> getAllExpenseItems(String dbName, String user, String password ) throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Expense_item";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        
        List<ExpenseItem> expenseItemList = new ArrayList<>();
        
        while(rst.next()){
            String category = rst.getString("category");
            
            ExpenseItem expenseItem = new ExpenseItem(category);
            expenseItemList.add(expenseItem);
        }
        return expenseItemList;
    }

    public List<ExpenseCatergory> vieWExpenseCategoryController(ExpenseCatergory expenseCat) throws ClassNotFoundException, SQLException{
        List<ExpenseCatergory> expList = new ArrayList<>();
        String sql="select *from Expense_item";
        Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
              String  category=rst.getString("category");
              ExpenseCatergory cat=new ExpenseCatergory(category);
              expList.add(cat);
              
            }
        return expList;
    }
    
    

}
