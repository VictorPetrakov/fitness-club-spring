package com.victorp.db.dao;

import com.victorp.model.User;

import java.util.List;

public interface UserDao extends GeneralDao<User> {


    List<User> getAll() throws Exception;

    User getById(Long id) throws Exception;

    User getByLogin(String login) throws Exception ;

    User signUp(String login, String password) throws Exception;

    User checkUser(String login);



}
