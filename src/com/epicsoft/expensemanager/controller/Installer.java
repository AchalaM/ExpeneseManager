/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.Install;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author User
 */
public class Installer {

    public void setDetails(String mysqlHost,String mysqlUsername,String mysqlPassword,String mysqlDbName,String accountUsername,String accountPassword){
        //DBController dbController=new DBController();
        
        try {
            //dbController.createTables();
            //dbController.setDefaultValue();
            
            Install installData=new Install(mysqlHost, mysqlUsername, mysqlPassword,mysqlDbName);
            
            FileOutputStream fout = new FileOutputStream("data.o");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            
            oos.writeObject(installData);
            oos.close();

        } catch(Exception ex){
            Logger.getLogger(Installer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);           
        }
          
        
    }
}
