package com.victorp.services;

import com.victorp.model.Admin;
import com.victorp.model.Client;
import com.victorp.model.Trainer;
import com.victorp.model.User;

public interface AuthorizationService {

    User authorizeUser(String login, String password) throws Exception;
}
