/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.main;

import com.epicsoft.expensemanager.controller.DBController;
import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.view.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.iapi.jdbc.BrokeredConnection;

/**
 *
 * @author hp
 */
public class Main {
    
    public static void main(String args[]) {
        LoginFrame loginframe = new LoginFrame();
        loginframe.setVisible(true);
        
    }
    
}
