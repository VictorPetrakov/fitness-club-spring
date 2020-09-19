package com.victorp.model;

import javax.persistence.*;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameWorkout;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Trainer trainer;

}
