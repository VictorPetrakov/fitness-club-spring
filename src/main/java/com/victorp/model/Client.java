package com.victorp.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GenericGenerator(name = "one-one", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))
    @GeneratedValue(generator = "one-one")
    @Column(name = "user_id")
    private Long id;

    @Column
    private String login;

    @Column
    private Long clientIdentifier;

    @Column
    private String nameGroup;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @ManyToOne
    @JoinColumn(name = "client_workoutGroup_id")
    private WorkoutGroup workoutGroup;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private WorkoutPersonal workoutPersonal;

    public Client() {
    }

    public Client(String login, String nameGroup) {
        this.login = login;
        this.nameGroup = nameGroup;
    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {

        this.login = login;
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

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public WorkoutGroup getWorkoutGroup() {

        return workoutGroup;
    }

    public void setWorkoutGroup(WorkoutGroup workoutGroup) {

        this.workoutGroup = workoutGroup;
    }

    public WorkoutPersonal getWorkoutPersonal() {

        return workoutPersonal;
    }

    public void setWorkoutPersonal(WorkoutPersonal workoutPersonal) {

        this.workoutPersonal = workoutPersonal;
    }

    public String getNameGroup() {

        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {

        this.nameGroup = nameGroup;
    }
}

