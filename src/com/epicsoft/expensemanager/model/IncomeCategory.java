/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.model;

/**
 *
 * @author DHANUSHKA
 */
public class IncomeCategory {
    private String incomeCategory;

    public IncomeCategory(String incomeCategory){
        this.incomeCategory = incomeCategory;
    }
    
    /**
     * @return the incomeCategory
     */
    public String getIncomeCategory() {
        return incomeCategory;
    }

    /**
     * @param incomeCategory the incomeCategory to set
     */
    public void setIncomeCategory(String incomeCategory) {
        this.incomeCategory = incomeCategory;
    }
    
    @Override
    public String toString(){
        return incomeCategory;
    }
}
