package com.victorp.services.impl;

import com.victorp.db.dao.impl.HibernateAdminDaoImpl;
import com.victorp.db.dao.impl.HibernateClientDaoImpl;
import com.victorp.db.dao.impl.HibernateTrainerDaoImpl;
import com.victorp.db.dao.impl.HibernateUserDaoImpl;
import com.victorp.model.Admin;
import com.victorp.model.Client;
import com.victorp.model.Trainer;
import com.victorp.model.User;
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
    public User authorizeUser(String login, String password) throws Exception {
        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        User user = hibernateUserDao.signUp(login,password);
        return user;
    }
}
