package com.victorp.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "client")
public class Client{

    private static final int idRole = 3;

    @Id
    @GenericGenerator(name = "one-one", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "user_id")
    private Long id;

    @Column
    private String name;

    @Column
    private Long clientIdentifier;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
    @ManyToOne
    private WorkoutGroup workoutGroup;
    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private WorkoutPersonal workoutPersonal;

    public Client() {
    }

    public Client(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClientIdentifier() {
        return clientIdentifier;
    }

    public void setClientIdentifier(Long clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

