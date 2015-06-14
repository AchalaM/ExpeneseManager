/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.ExpenseCategory;
import com.epicsoft.expensemanager.model.ExpenseSubCategory;
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
public class ExpenseSubCategoryController {
    
    public List<ExpenseSubCategory> vieWExpenseCategoryController(ExpenseCategory Category) throws ClassNotFoundException, SQLException{
        List<ExpenseSubCategory> expList = new ArrayList<>();
        String sql="select sub_category from expense_categories where category = \""+Category.getCatergory()+"\"";
        Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
              String  subcategory=rst.getString("sub_category");
              ExpenseSubCategory cat = new ExpenseSubCategory(subcategory);
              expList.add(cat);
              
            }
        return expList;
    }
    public int AddExpenseSubCategoryController(ExpenseSubCategory subCatergory) throws ClassNotFoundException, SQLException{
        
        String sql="insert into expense_categories values('"+subCatergory.getSubCatogory()+"')";
        Connection connection = DBConnection.getInstance().getConnection();
        try{
            Statement stm = connection.createStatement();
            int res = stm.executeUpdate(sql);
            if(res>0){
                return  1;
            }
            
        }
        catch(SQLException ex){
            connection.rollback();
            throw ex;
        }
        return -1;
    }
    public int DeleteExpenseSubCatergoryController(ExpenseSubCategory subCatergory) throws ClassNotFoundException, SQLException{
    
        String sql="DELETE from expense_categories where sub_category='"+subCatergory.getSubCatogory()+"'";
        Connection connection = DBConnection.getInstance().getConnection();
        try{
            
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            
        }
        catch(SQLException ex){
            System.out.println("not delete");
        }
        return 0;
    }
    public int EditExpenseSubCategoryController(ExpenseSubCategory subCatergory,ExpenseCategory category) throws ClassNotFoundException, SQLException{
        String sql = "update expense_categories set category='"+category.getCatergory()+"',sub_category="+subCatergory.getSubCatogory()+", where ='"+subCatergory.getSubCatogory()+"'";
        Connection connection = DBConnection.getInstance().getConnection();
        try{
            Statement stm = connection.createStatement();
            int res = stm.executeUpdate(sql);
            if(res>0){
                return  1;
            }
            
        }
        catch(SQLException ex){
            connection.rollback();
            throw ex;
        }
        return -1;
    
    }
}
