package com.victorp.services;

import com.victorp.model.Contact;

public interface AuthorizationService {

    Contact authorize(String login, String password);
}
