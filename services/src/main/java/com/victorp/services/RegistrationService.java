package com.victorp.services;

import com.victorp.model.*;

public interface RegistrationService {

    void createClient(Client client, User user, UserRole userRole) throws Exception;

    void createTrainer(Trainer trainer, User user, UserRole userRole) throws Exception;

    void createAdmin(Admin admin, User user, UserRole userRole) throws Exception;

    User checkUser(String login) throws Exception;

    boolean checkUserRole(String name) throws Exception;

    UserRole getUserRole(String name) throws Exception;


}
