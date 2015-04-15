/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.model;

/**
 *
 * @author SUPUN MADUSHANKA
 */
public class UserAccount {
    private String userName;
    private String Name;
    private String currencyType;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    public UserAccount(String userName, String Name, String currencyType) {
        this.userName = userName;
        this.Name = Name;
        this.currencyType = currencyType;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }
}
