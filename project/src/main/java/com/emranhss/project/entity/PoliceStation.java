package com.emranhss.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "policestations")
public class PoliceStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;
}


