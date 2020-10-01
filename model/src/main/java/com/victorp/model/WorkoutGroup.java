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

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Workout workout;

    @OneToMany(mappedBy = "workoutGroup")
    private List<Client> clientList;
    @Column
    private String trainingTime;

    public WorkoutGroup() {
    }

    public WorkoutGroup(List<Client> clientList, String trainingTime) {

        this.clientList = clientList;
        this.trainingTime = trainingTime;
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

