package com.victorp.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "user_role")

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean admin;

    @OneToMany(mappedBy = "userRole")
    private List<User> users = new ArrayList<>();

    public UserRole() {
    }

    public UserRole(String name, Boolean admin) {
        this.name = name;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<User> getContacts() {
        return users;
    }

    public void setContacts(List<User> users) {
        this.users = users;
    }

    public void addContact(User user) {
        this.users.add(user);
    }

}
