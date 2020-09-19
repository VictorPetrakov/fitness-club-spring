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
    private String name;

    @Column
    private Long trainerIdentifier;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @OneToOne(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Workout workout;


    private static final int idRole = 2;

    public Trainer() {
    }
    public Trainer(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
