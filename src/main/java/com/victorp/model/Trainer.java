package com.victorp.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GenericGenerator(name = "one-one", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "user_id")
    private Long id;

    @Column
    private String username;

    @Column
    private Long trainerIdentifier;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @OneToOne(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Workout workout;

    public Trainer() {
    }

    public Trainer(String username) {

        this.username = username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getUsername() {

        return username;
    }

    public Long getTrainerIdentifier() {

        return trainerIdentifier;
    }

    public void setTrainerIdentifier(Long trainerIdentifier) {

        this.trainerIdentifier = trainerIdentifier;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }


}
