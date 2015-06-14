/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.model;

import java.sql.Date;

/**
 *
 * @author SUPUN MADUSHANKA
 */
public class Income {
    private String AccountName;
    private Date Date; 
    private String Category;
    private double amount;
    private String description;
    private String paymentMethod;


    public Income(String AccountName, Date Date, String Category, double amount, String description,String paymentMethod) {
        this.AccountName = AccountName;
        this.Date = Date;
        this.Category = Category;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.description = description;
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
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    /**
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(String Category) {
        this.Category = Category;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
