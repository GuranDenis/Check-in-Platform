package com.ibm.checkin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Table(name = "features")
@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private Classroom classroom;

    private String name;

    public Feature() {
    }

    public Feature(Classroom classroom, String name) {
        this.classroom = classroom;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String feature) {
        this.name = feature;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", classroom=" + classroom +
                ", feature='" + name + '\'' +
                '}';
    }
}
