/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.*;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author hp
 */
public class DBController {
    
    public void addNewUser(User user){
        
    }
    
    public void createDB() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance("test;create=true", "", "").getConnection();
        System.out.println("Connection ok!");
    }
    
    public void createTables(){
      
    }
    
    public void dropDB(){
        
    }
    
}
