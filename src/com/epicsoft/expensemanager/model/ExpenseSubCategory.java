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
public class ExpenseSubCategory {
    private String subCatogory;

    public ExpenseSubCategory(String subCatogory) {
        this.subCatogory = subCatogory;
    }

    /**
     * @return the subCatogory
     */
    public String getSubCatogory() {
        return subCatogory;
    }

    /**
     * @param subCatogory the subCatogory to set
     */
    public void setSubCatogory(String subCatogory) {
        this.subCatogory = subCatogory;
    }
    
}
