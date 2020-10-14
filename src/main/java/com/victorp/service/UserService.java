package com.victorp.service;

import com.victorp.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getById(Long id) throws Exception;

    List<User> getAll() throws Exception;

    User getByUsername(String username) throws Exception;

    User checkUser(String login);

    User create(User item) throws Exception;

    User update(User item) throws Exception;

    void delete(Long id) throws Exception;
    boolean saveClient(User user) throws Exception;
    boolean saveAdmin(User user) throws Exception;
    boolean saveTrainer(User user) throws Exception;
}
