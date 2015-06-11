/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.controller;

import com.epicsoft.expensemanager.db.DBConnection;
import com.epicsoft.expensemanager.model.Currency;
import com.epicsoft.expensemanager.model.User;
import com.epicsoft.expensemanager.model.UserAccount;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.iapi.jdbc.BrokeredConnection;

/**
 *
 * @author hp
 */
public class UserController {
    
    /**
     * Add new user to the database.
     * @param user
     * @param userAccount
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public boolean addNewUser(User user, UserAccount userAccount) throws ClassNotFoundException, SQLException {
        try {
            String name = userAccount.getName();
            String username = userAccount.getUserName();
            String currencyType = userAccount.getCurrencyType();
            String currencySymbol = userAccount.getCurrencySymbol();
            String typedpassword = user.getPassWord();
            
            String password = PasswordHashing.createHash(typedpassword);
            
            String sql_addUser = "Insert into userLoginInfo values (\""+username+"\",\""+password+"\")";
            String sql_addUserAcc = "Insert into user_account values (\""+username+"\",\""+name+"\",\""+currencyType+"\",\""+currencySymbol+"\")";
            
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            
            stm.executeUpdate(sql_addUser);
            stm.executeUpdate(sql_addUserAcc);

            return true;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean validateUsername(String username) throws ClassNotFoundException, SQLException {
        boolean alreadyExist = false;

            String sql = "Select username from userlogininfo where username = \""+username+"\"";
            
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            
            ResultSet result = stm.executeQuery(sql);
            
            if (result.next())
                if (result.getObject("username").equals(username))
                    alreadyExist = true;              

        
        return alreadyExist;
    }
       
    /**
     * Get the values from currency table
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public List<Currency> getCurrencyDetail() throws ClassNotFoundException, SQLException {
        
        String sql = "Select * from Currency";
        
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        
         ResultSet rst = stm.executeQuery(sql);
         
         List<Currency> currencyDetailList = new ArrayList<>();
         
         while (rst.next()){
             String curType = rst.getString("currencyType");
             String symbol = rst.getString("Symbol");
             
             Currency currency = new Currency(curType,symbol);
             
             currencyDetailList.add(currency);
             
         }
        return currencyDetailList;
    }
}
