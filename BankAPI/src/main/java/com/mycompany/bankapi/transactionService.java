/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aaron
 */
public class transactionService {
    public static void main(String[] args){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance-connect");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();        
    }
}