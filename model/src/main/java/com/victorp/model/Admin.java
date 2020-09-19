package com.victorp.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "admin")
public class Admin{

    private static final int idRole = 1;

    @Id
    @GenericGenerator(name = "one-one", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "user_id")
    private Long id;

    @Column
    private String name;

    @Column
    private Long adminIdentifier;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Admin() {
    }
    public Admin(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAdminIdentifier() {
        return adminIdentifier;
    }

    public void setAdminIdentifier(Long adminIdentifier) {
        this.adminIdentifier = adminIdentifier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
