/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rostifur
 */
@Path("/bankapp")
public class BankService {
    
    private int userSession = 0;
    BankResource res = new BankResource();
    
    // Entry Point 1: Account Selection
    @GET
    @Path("accounts/{uid}")
    public Response getBankAccounts(@PathParam("uid") 
            String uid) {
        
        String output = "This entry point will return all bank accounts for the user: " + uid;
        return Response.status(200).entity(output).build();
        
    }
    
    // Entry Point 2: User - Create Account
    @POST
    @Path("/user/account")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUserAccount(String accountDetails){
        
        System.out.println(accountDetails);
        
    }
    
    // Entry Point 3: User - Delete Account
    @DELETE
    @Path("/user/account/{uid}")
    public void deleteUserAccount(@PathParam("uid") 
            String uid) {
        int id = Integer.parseInt(uid);
        System.out.println(uid);
    }
    
    // Entry Point 4: User - Account Details
    @GET
    @Path("user/account/{uid}")
    public Response getUserDetails(@PathParam("uid") 
            String uid) {
        
        String output = "This entry point will return the account details for the user: " + uid;
        return Response.status(200).entity(output).build();
        
    }
    
    // Entry Point 5: User - Edit Account (Password)
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("user/account/password")
    public void updatePassword(String password) {
        System.out.println(password);
    }
    
    // Entry Point 6: User - Edit Account (Address)
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("user/account/address")
    public void updateAddress(String address) {
        System.out.println(address);
    }
    
    // Entry Point 7: Account - Transaction (History)
    @GET
    @Path("account/transactions/{account_id}")
    public Response getAccountTransactions(@PathParam("account_id") 
            String accountId) {
        
        String output = "This entry point will return all transactions related to the account: " + accountId;
        return Response.status(200).entity(output).build();
        
    }
    
    // Entry Point 8: Transaction (Lodgement)
    @POST
    @Path("account/transactions/lodgment")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountLodgment(String lodgment){
        
        System.out.println(lodgment);
        
    }
    
    // Entry Point 9: Transaction (Withdrawal)
    @POST
    @Path("account/transactions/withdraw")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountWithdrawal(String withdrawal){
        
        System.out.println(withdrawal);
        
    }
    
    // Entry Point 10: Transaction (Transfer)
    @POST
    @Path("account/transactions/transfer")
    @Consumes(MediaType.APPLICATION_JSON)
    public void accountTransfer(String transfer){
        
        System.out.println(transfer);
        
    }
    
    // Entry Point 11: User - Log In
    @POST
    @Path("user/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void userLogIn(@FormParam("email") String email, @FormParam("password") String password){
        
        // set the userSession Variable here
        System.out.println(email + password);
        
    }
    
    // Entry Point 12: User - Log Out
    @POST
    @Path("user/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    public void userLogOut(String uid){
        
        System.out.println(uid);
        
    }
    
    // Entry Point 13: Bank - Create Account
    @POST
    @Path("bank/account")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBankAccount(String bankAccountDetails){
        
        System.out.println(bankAccountDetails);
        
    }
    
    // Entry Point 14: Bank - Delete Account
    @DELETE
    @Path("bank/account/{account_id}")
    public void deleteBankAccunt(@PathParam("account_id") 
            String accountId) {
        int id = Integer.parseInt(accountId);
        System.out.println(id);
    }
    
    // Entry Point 15: Bank - Account Details
    @GET
    @Path("bank/account/{account_id}")
    public Response getBankAccountDetails(@PathParam("account_id") 
            String accountId) {
        
        String output = "This entry point will return all details related to the bank account: " + accountId;
        return Response.status(200).entity(output).build();
        
    } 
    
}
