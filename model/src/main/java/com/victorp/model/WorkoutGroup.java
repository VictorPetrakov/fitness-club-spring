package com.victorp.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class WorkoutGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Trainer trainer;

    @OneToMany(mappedBy = "workoutGroup")
    private List<Client> clientList;
    @Column
    private String trainingTime;

    public WorkoutGroup() {
    }

    public WorkoutGroup(Trainer trainer, List<Client> clientList, String trainingTime) {
        this.trainer = trainer;
        this.clientList = clientList;
        this.trainingTime = trainingTime;
    }

    public Trainer getTrainer() {

        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Client> getClientList() {

        return clientList;
    }

    public void setClientList(List<Client> clientList) {

        this.clientList = clientList;
    }
    public void setClientToGroup(Client client) {

        this.clientList.add(client);
    }

    public void setClientList(Client client){

        this.clientList.add(client);
    }

    public String getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(String trainingTime) {

        this.trainingTime = trainingTime;
    }

}

