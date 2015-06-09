/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.model;

/**
 *
 * @author hp
 */
public class ExpenseItem {
    
    private String category;

    public ExpenseItem(String category) {
        this.category = category;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString(){
        return category;
    }
    
}
