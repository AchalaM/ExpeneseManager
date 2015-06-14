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
public class Account {
    
    private String AccountName;
    private String accountType;
    private double initialBalance;
    private double currentBalance;

    public Account(String AccountName, String accountType, double initialBalance, double currentBalance) {
        this.AccountName = AccountName;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.currentBalance = currentBalance;
    }
    

    /**
     * @return the AccountName
     */
    public String getAccountName() {
        return AccountName;
    }

    /**
     * @param AccountName the AccountName to set
     */
    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the initialBalance
     */
    public double getInitialBalance() {
        return initialBalance;
    }

    /**
     * @param initialBalance the initialBalance to set
     */
    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    /**
     * @return the currentBalance
     */
    public double getCurrentBalance() {
        return currentBalance;
    }

    /**
     * @param currentBalance the currentBalance to set
     */
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    
}
