/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.Expend;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SUPUN MADUSHANKA
 */
public class ExpenseController {
    public int addExpenses(Expend expense) throws ClassNotFoundException, SQLException{
    
        String sql = "insert into expend values('"+expense.getAccountName()+"','"+expense.getData()+"',"+expense.getAmount()+",'"+expense.getCategory()+"','"+expense.getPaymentMothod()+"','"+expense.getDiscription()+"')";
        Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
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

    /**
     *
     * @param date
     * @param accountName
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Expend> viewExpense(int date,String accountName,String RealDate) throws SQLException,ClassNotFoundException{
        int year=1,alltime=0,daly=3,monthly=2;
        
        List<Expend> expList = new ArrayList<>();
        try{
        if(date==alltime){
            String sql="select *from expend";
            Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String account=rst.getString("account");
                String Date=rst.getString("expDate");
                int amount=rst.getInt("amount");
                String catogory=rst.getString("category");
                String paymentMethod=rst.getString("paymentMethod");
                String description=rst.getString("description");
                Expend expense=new Expend(paymentMethod, account, Date, catogory, amount, description);
                expList.add(expense);
            }
            
        }
        if(date==year){
            String sql="select * from (select DATEPART(yyyy,expDate) as yearCol from expend)where yearCol ="+RealDate;
            Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String account=rst.getString("account");
                String Date=rst.getString("expDate");
                int amount=rst.getInt("amount");
                String catogory=rst.getString("category");
                String paymentMethod=rst.getString("paymentMethod");
                String description=rst.getString("description");
                Expend expense=new Expend(paymentMethod, account, Date, catogory, amount, description);
                expList.add(expense);
            }
        }
        if(date==monthly){
            String sql="select * from (select DATEPART(mm,expDate) as monthCol from expend) where monthCol="+RealDate ;
            Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String account=rst.getString("account");
                String Date=rst.getString("expDate");
                int amount=rst.getInt("amount");
                String catogory=rst.getString("category");
                String paymentMethod=rst.getString("paymentMethod");
                String description=rst.getString("description");
                Expend expense=new Expend(paymentMethod, account, Date, catogory, amount, description);
                expList.add(expense);
            }
        }
        if(date==daly){
            String sql="select *from expend where expDate='"+RealDate+"'";
            Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String account=rst.getString("account");
                String Date=rst.getString("expDate");
                int amount=rst.getInt("amount");
                String catogory=rst.getString("category");
                String paymentMethod=rst.getString("paymentMethod");
                String description=rst.getString("description");
                Expend expense=new Expend(paymentMethod, account, Date, catogory, amount, description);
                expList.add(expense);
            }
        }
        }
        catch(SQLException ex){
            System.out.println("error of edit");
        }
        
        return expList;
    
    
    }
    public int deleteExpense(Expend exp) throws ClassNotFoundException, SQLException{
        
        String sql="DELETE from expend where account='"+exp.getAccountName()+"',expDate='"+exp.getData()+"',amount="+exp.getAmount()+",category='"+exp.getCategory()+"',paymentMethod='"+exp.getPaymentMothod()+"',description='"+exp.getDiscription()+"'";
        Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
        try{
            
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            
        }
        catch(SQLException ex){
            System.out.println("not delete");
        }
        return 0;
    
    }
    public int editExpense(Expend expense,int ID) throws ClassNotFoundException, SQLException{
        String sql = "update expend set account='"+expense.getAccountName()+"' ,expDate='"+expense.getData()+"',ammount="+expense.getAmount()+",category='"+expense.getCategory()+"',paymentMethod='"+expense.getPaymentMothod()+"',description='"+expense.getDiscription()+"' where expIndex="+ID;
        Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
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
    
    public  ResultSet searchExpense(String column,String Value) throws ClassNotFoundException, SQLException {
        Expend expens;
        String sql= "select * from expend where"+ column+"="+Value;
        Connection connection = DBConnection.getInstance("testuser","testuser","epicsoft").getConnection();
        try{
            Statement stm = connection.createStatement();
            ResultSet resultSet=stm.executeQuery(sql);
            
            return resultSet;
            
        }
        catch(SQLException ex){
            connection.rollback();
            throw ex;
        }
        
    }
    
    
    
}  
    

