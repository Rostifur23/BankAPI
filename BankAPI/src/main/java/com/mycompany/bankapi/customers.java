/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author Aaron
 */
@Entity
@Table
@XmlRootElement
public class customers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;
    
    private String name;
    private String customer_adr;
    private String email;
    private String password;
      
    public customers(int customer_id, String name, String customer_adr, String email, String password){
        super();
        this.customer_id = customer_id;
        this.name = name;
        this.customer_adr = customer_adr;
        this.email = email;
        this.password = password;
    }
    
    public customers(){
        accounts = new ArrayList<>();
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerAdr() {
        return customer_adr;
    }

    public void setCustomerAdr(String customer_adr) {
        this.customer_adr = customer_adr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @OneToMany(targetEntity=account.class, cascade = CascadeType.ALL, mappedBy="cust")
    private List<account> accounts;
    
    private void setAccounts(List<account> accountlist){
        this.accounts = accountlist;
    }
    
    @XmlElementWrapper(name="account")
    @XmlElementRef()
    public List<account> getAccounts(){
        return accounts;
    }
    
    public static void main(String[] args){
        
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance_connect");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
                
        customers cust = new customers();

        entitymanager.persist(cust);

        account acc1 = new account(1, 123, 23, 50.00, "checking");

        acc1.setCustomer(cust);

        // entitymanager.persist(trans1);
        ArrayList<account> accounts = new ArrayList<>();
        
        accounts.add(acc1);
        
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close(); 
    }
        
}
