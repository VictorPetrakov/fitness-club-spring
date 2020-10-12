package com.victorp.service;

import com.victorp.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {
    User getById(Long id) throws Exception;

    List<User> getAll() throws Exception;

    User getByLogin(String login) throws Exception;

    User signUp(String login, String password) throws Exception;

    User checkUser(String login);

    User create(User item) throws Exception;

    User update(User item) throws Exception;

    void delete(Long id) throws Exception;
    boolean saveUser(User user) throws Exception;
}
