package com.eiasin.crems.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String location;

    @Column(length = 50, nullable = false)
    private Date startDate;

    @Column(length = 50, nullable = false)
    private Date endDate;

    @Column(length = 50, nullable = false)
    private long budget;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(length = 50, nullable = false)
    private String projectType;

    @Column(length = 50, nullable = false)
    private String projectManager;

    @Column(length = 255, nullable = true)
    private String description;

}
