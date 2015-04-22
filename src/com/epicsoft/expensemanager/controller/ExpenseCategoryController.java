/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;
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
    public List<ExpenseCatergory> vieWExpenseCategoryController(ExpenseCatergory expenseCat) throws ClassNotFoundException, SQLException{
        List<ExpenseCatergory> expList = new ArrayList<>();
        String sql="select *from Expense_item";
        Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
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
