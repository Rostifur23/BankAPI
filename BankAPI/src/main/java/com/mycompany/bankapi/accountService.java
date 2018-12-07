/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Path;

/**
 *
 * @author Aaron
 */
@Path("/test")
public class accountService {
    public static void main(String [] args){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance-connect");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
        customers acc = new customers();
        
        account acc1 = new account(1, 123, 23, 50.00, "checking", 1);   
        
        acc1.setCust(acc);
        
        entitymanager.persist(acc1);
        
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }
}
