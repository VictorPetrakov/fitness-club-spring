package com.victorp.repository;

import com.victorp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.login = :login")
    User findByLogin(@Param("login") String login);
    @Query("select u from User u where u.login = :login AND u.password = :password")
    User signUp(@Param("login") String login, @Param("password") String password);
}
