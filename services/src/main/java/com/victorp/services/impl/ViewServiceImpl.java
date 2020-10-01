package com.victorp.services.impl;

import com.victorp.db.dao.impl.HibernateAdminDaoImpl;
import com.victorp.db.dao.impl.HibernateClientDaoImpl;
import com.victorp.db.dao.impl.HibernateTrainerDaoImpl;
import com.victorp.model.Admin;
import com.victorp.model.Client;
import com.victorp.model.Trainer;
import com.victorp.services.ViewService;


import java.util.List;

public class ViewServiceImpl implements ViewService {

    private static ViewService instance;

    public static ViewService getInstance() {
        if (instance == null) {
            synchronized (ViewService.class) {
                if (instance == null) {
                    instance = new ViewServiceImpl();
                }
            }
        }
        return instance;
    }

    private ViewServiceImpl() {

    }

    @Override
    public List<Client> viewClients() throws Exception {
        HibernateClientDaoImpl hibernateClientDao = new HibernateClientDaoImpl();
        List<Client> clientList = hibernateClientDao.getAll();
        return clientList;
    }

    @Override
    public List<Admin> viewAdmins() throws Exception {
        HibernateAdminDaoImpl hibernateAdminDao = new HibernateAdminDaoImpl();
        List<Admin> adminList = hibernateAdminDao.getAll();
        return adminList;
    }

    @Override
    public List<Trainer> viewTrainers() throws Exception {
        HibernateTrainerDaoImpl hibernateTrainerDao = new HibernateTrainerDaoImpl();
        List<Trainer> trainerList = hibernateTrainerDao.getAll();
        return trainerList;
    }
}
