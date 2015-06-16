/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epicsoft.expensemanager.model;
import java.io.Serializable;
/**
 *
 * @author User
 */
public class Install implements Serializable{
    private String mysqlHost;
    private String mysqlUsername;
    private String mysqlPassword;
    private String mysqlDB;

    /**
     * @return the mysqlHost
     */
    public Install(String mysqlHost,String mysqlUsername, String mysqlPassword, String mysqlDB){
        this.mysqlHost=mysqlHost;
        this.mysqlPassword=mysqlPassword;
        this.mysqlUsername=mysqlUsername;
        this.mysqlDB=mysqlDB;
    }
    public String getMysqlHost() {
        return mysqlHost;
    }

    /**
     * @param mysqlHost the mysqlHost to set
     */
    public void setMysqlHost(String mysqlHost) {
        this.mysqlHost = mysqlHost;
    }

    /**
     * @return the mysqlUsername
     */
    public String getMysqlUsername() {
        return mysqlUsername;
    }

    /**
     * @param mysqlUsername the mysqlUsername to set
     */
    public void setMysqlUsername(String mysqlUsername) {
        this.mysqlUsername = mysqlUsername;
    }

    /**
     * @return the mysqlPassword
     */
    public String getMysqlPassword() {
        return mysqlPassword;
    }

    /**
     * @param mysqlPassword the mysqlPassword to set
     */
    public void setMysqlPassword(String mysqlPassword) {
        this.mysqlPassword = mysqlPassword;
    }

    /**
     * @return the mysqlDB
     */
    public String getMysqlDB() {
        return mysqlDB;
    }

    /**
     * @param mysqlDB the mysqlDB to set
     */
    public void setMysqlDB(String mysqlDB) {
        this.mysqlDB = mysqlDB;
    }
    
    
}
