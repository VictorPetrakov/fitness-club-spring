package com.victorp.model;

import javax.persistence.*;

@Entity
public class WorkoutPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @OneToOne
    private Client client;
    @Column
    private String trainingTime;

    public WorkoutPersonal() {
    }

    public WorkoutPersonal(Client client, String trainingTime) {
        this.client = client;
        this.trainingTime = trainingTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(String trainingTime) {
        this.trainingTime = trainingTime;
    }
}
