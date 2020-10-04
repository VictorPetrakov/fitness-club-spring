package com.victorp.services.impl;

import com.victorp.db.dao.impl.*;
import com.victorp.model.*;
import com.victorp.services.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {
    private static RegistrationService instance;

    public static RegistrationService getInstance() {

        if (instance == null) {
            synchronized (RegistrationService.class) {
                if (instance == null) {
                    instance = new RegistrationServiceImpl();
                }
            }
        }
        return instance;
    }

    private RegistrationServiceImpl() {
    }


    @Override
    public void createTrainer(Trainer trainer, User user, UserRole userRole) throws Exception {
        HibernateTrainerDaoImpl hibernateTrainerDao = new HibernateTrainerDaoImpl();
        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        HibernateUserRoleDaoImpl hibernateUserRoleDao = new HibernateUserRoleDaoImpl();
        hibernateUserDao.create(user);
        hibernateTrainerDao.create(trainer);
        hibernateUserRoleDao.create(userRole);
    }

    @Override
    public void createAdmin(Admin admin, User user, UserRole userRole) throws Exception {
        HibernateAdminDaoImpl hibernateAdminDao = new HibernateAdminDaoImpl();
        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        HibernateUserRoleDaoImpl hibernateUserRoleDao = new HibernateUserRoleDaoImpl();
        hibernateUserDao.create(user);
        hibernateAdminDao.create(admin);
        hibernateUserRoleDao.create(userRole);
    }

    @Override
    public void createClient(Client client, User user, UserRole userRole) throws Exception {
        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        HibernateClientDaoImpl hibernateClientDao = new HibernateClientDaoImpl();
        HibernateUserRoleDaoImpl hibernateUserRoleDao = new HibernateUserRoleDaoImpl();
        hibernateUserDao.create(user);
        hibernateClientDao.create(client);
        hibernateUserRoleDao.create(userRole);

    }


    @Override
    public User checkUser(String login) throws Exception {
        HibernateUserDaoImpl hibernateUserDao = new HibernateUserDaoImpl();
        return  hibernateUserDao.checkUser(login);
    }

    @Override
    public boolean checkUserRole(String name) throws Exception {
        HibernateUserRoleDaoImpl hibernateUserRoleDao = new HibernateUserRoleDaoImpl();
        return hibernateUserRoleDao.checkUserRole(name);
    }

    @Override
    public UserRole getUserRole(String name) throws Exception {
        HibernateUserRoleDaoImpl hibernateUserRoleDao = new HibernateUserRoleDaoImpl();
        return hibernateUserRoleDao.getUserRole(name);

    }


}
