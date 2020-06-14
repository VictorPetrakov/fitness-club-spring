package com.victorp.services.impl;

import com.victorp.model.Contact;
import com.victorp.services.AuthorizationService;

public class AuthorizationServiceImpl implements AuthorizationService {

   private static AuthorizationService instance;

    public static AuthorizationService getInstance(){

        if(instance == null){
            synchronized (AuthorizationService.class){
                if(instance == null){
                    instance = new AuthorizationServiceImpl();
                }
            }
        }
        return instance;
    }
    private AuthorizationServiceImpl(){}


    @Override
    public Contact authorize(String login, String password) {
        if("admin".equals(login) && "admin".equals(password) ) {
            return new Contact("admin", "admin", "Victor", "Petrakov");
        }else{
            return null;
        }
    }
}