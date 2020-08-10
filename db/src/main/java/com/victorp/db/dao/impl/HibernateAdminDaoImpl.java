package com.victorp.db.dao.impl;

import com.victorp.db.dao.AdminDao;
import com.victorp.model.Admin;

import java.util.List;

public class HibernateAdminDaoImpl implements AdminDao {
    @Override
    public Admin signUp(String login, String password) throws Exception {
        return null;
    }

    @Override
    public Admin getByLogin(String login) throws Exception {
        return null;
    }

    @Override
    public Admin get(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Admin> getAll() throws Exception {
        return null;
    }

    @Override
    public void create(Admin item) throws Exception {

    }

    @Override
    public void update(Admin item) throws Exception {

    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
