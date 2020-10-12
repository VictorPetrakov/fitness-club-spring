package com.victorp.service.impl;

import com.victorp.model.Client;
import com.victorp.model.User;
import com.victorp.model.UserRole;
import com.victorp.repository.ClientRepository;
import com.victorp.repository.UserRepository;
import com.victorp.repository.UserRoleRepository;
import com.victorp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public User getById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<User> getAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User getByLogin(String login) throws Exception {
        return userRepository.findByLogin(login);
    }

    @Override
    public User signUp(String login, String password) throws Exception {
        return userRepository.signUp(login, password);
    }

    @Override
    public User checkUser(String login) {
        return null;
    }

    @Override
    public User create(User item) throws Exception {
        return userRepository.saveAndFlush(item);
    }
    @Override
    public boolean saveUser(User user) throws Exception{
        User userFromDB = userRepository.findByLogin(user.getLogin());
        UserRole userRoleFromDB = userRoleRepository.findByName("ROLE_CLIENT");
        final Client client = new Client();

        if (userFromDB != null) {
            return false;
        }
        if(userRoleFromDB != null){
            user.setUserRole(userRoleFromDB);
        }else{
            user.setUserRole(new UserRole("ROLE_CLIENT", false, false));
        }

        client.setUser(user);
        client.setLogin(user.getLogin());
        client.setClientIdentifier((long) (Math.random() * 20000 - 0));

        user.setClient(client);

        userRepository.saveAndFlush(user);
        return true;
    }

    @Override
    public User update(User item) throws Exception {

        return userRepository.saveAndFlush(item);
    }

    @Override
    public void delete(Long id) throws Exception {
        userRepository.deleteById(id);

    }

}
