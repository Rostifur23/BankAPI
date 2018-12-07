/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aaron
 */
@Entity
@Table
@XmlRootElement
public class account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int account_id;
    
    private int sort_code;
    private int account_num;
    private double balance;
    private String account_type;
    private int customer_id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private customers cust;

    public account(int account_id, int sort_code, int account_num, double balance, String account_type, int customer_id) {
        this.account_id =  account_id;
        this.sort_code = sort_code;
        this.account_num = account_num;
        this.balance = balance;
        this.account_type = account_type;
        this.customer_id = customer_id;
    }

    public customers getCust() {
        return cust;
    }

    public void setCust(customers cust) {
        this.cust = cust;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getSort_code() {
        return sort_code;
    }

    public void setSort_code(int sort_code) {
        this.sort_code = sort_code;
    }

    public int getAccount_num() {
        return account_num;
    }

    public void setAccount_num(int account_num) {
        this.account_num = account_num;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }  
    
    
    
    
}
