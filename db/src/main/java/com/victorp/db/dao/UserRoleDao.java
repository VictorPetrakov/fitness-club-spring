package com.victorp.db.dao;

import com.victorp.model.UserRole;

public interface UserRoleDao extends GeneralDao<UserRole>{

    boolean checkUserRole(String name);

    UserRole getUserRole(String name);
}
