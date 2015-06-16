/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.Rotation;
/**
 *
 * @author User
 */
public class ReportController {
    
    public static XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };

        ds.addSeries("series1", data);

        return ds;
    }
    
    public PieDataset createExpenseCatagoryDataset(String dateFrom,String dateTo )
   {
      
       try{
          DefaultPieDataset dataset = new DefaultPieDataset( );

            Connection connection = DBConnection.getInstance().getConnection();

            String sql="SELECT sum(ammount),category FROM expend where expdate between '".concat(dateFrom).concat("' and '").concat(dateTo).concat("' group by category");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String category=new String(rst.getString("category")); 
                double ammount=rst.getDouble("sum(ammount)");
                System.out.println(ammount+" "+category);
                dataset.setValue( category , new Double( ammount ) );  
                
            }
            return dataset;
            
       }catch(Exception ex){
            System.out.println("error of edit");
       }
        return null;
   }
    public PieDataset createIncomeCatagoryDataset(String dateFrom,String dateTo )
   {
      
       try{
          DefaultPieDataset dataset = new DefaultPieDataset( );

            Connection connection = DBConnection.getInstance().getConnection();

            String sql="SELECT sum(amount),category FROM earn where incDate between '".concat(dateFrom).concat("' and '").concat(dateTo).concat("' group by category");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String category=new String(rst.getString("category")); 
                double ammount=rst.getDouble("sum(amount)");
                System.out.println(ammount+" "+category);
                dataset.setValue( category , new Double( ammount ) );  
                
            }
            return dataset;
            
       }catch(Exception ex){
            System.out.println("error of edit");
       }
        return null;
   }
    public PieDataset createExpensePaymentDataset(String dateFrom,String dateTo )
   {
      
       try{
          DefaultPieDataset dataset = new DefaultPieDataset( );

            Connection connection = DBConnection.getInstance().getConnection();

            String sql="SELECT sum(ammount),paymentMethod FROM expend where expDate between '".concat(dateFrom).concat("' and '").concat(dateTo).concat("' group by paymentMethod");
            System.out.println(sql);
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String category=new String(rst.getString("paymentMethod")); 
                double ammount=rst.getDouble("sum(ammount)");
                System.out.println(ammount+" "+category);
                dataset.setValue( category , new Double( ammount ) );  
                
            }
            return dataset;
            
       }catch(Exception ex){
            System.out.println("error of edit");
       }
        return null;
   }
    public PieDataset createIncomePaymentDataset(String dateFrom,String dateTo )
   {
      
       try{
          DefaultPieDataset dataset = new DefaultPieDataset( );

            Connection connection = DBConnection.getInstance().getConnection();

            String sql="SELECT sum(amount),paymentMethod FROM earn where incDate between '".concat(dateFrom).concat("' and '").concat(dateTo).concat("' group by paymentMethod");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String category=new String(rst.getString("paymentMethod")); 
                double ammount=rst.getDouble("sum(amount)");
                System.out.println(ammount+" "+category);
                dataset.setValue( category , new Double( ammount ) );  
                
            }
            return dataset;
            
       }catch(Exception ex){
            System.out.println("error of edit");
       }
        return null;
   }
   public CategoryDataset createExpenseTimeDataset(String dateFrom,String dateTo )
   {
       try{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
        
        Connection connection = DBConnection.getInstance().getConnection();

            String sql="SELECT sum(ammount),expDate FROM expend where expDate between '".concat(dateFrom).concat("' and '").concat(dateTo).concat("' group by expDate order by expDate");
            System.out.println(sql);
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String date=new String(rst.getString("expDate")); 
                double ammount=rst.getDouble("sum(ammount)");
                dataset.addValue(ammount, "expense", date);
                
                
            }
        

        return dataset;
       }catch(Exception ex){
           System.out.println("error db");
       }
       return null;
   }
   public CategoryDataset createEarnTimeDataset(String dateFrom,String dateTo )
   {
       try{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
        
        Connection connection = DBConnection.getInstance().getConnection();

            String sql="SELECT sum(amount),incDate FROM earn where incDate between '".concat(dateFrom).concat("' and '").concat(dateTo).concat("' group by incDate order by incDate");
            System.out.println(sql);
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                String date=new String(rst.getString("incDate")); 
                double ammount=rst.getDouble("sum(amount)");
                dataset.addValue(ammount, "earn", date);
                
                
            }
        

        return dataset;
       }catch(Exception ex){
           System.out.println("error db");
       }
       return null;
   }
}
