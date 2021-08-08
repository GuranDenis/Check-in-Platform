package com.ibm.checkin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "classrooms")
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int location;
    @Column(nullable = false)
    private int capacity;
    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    private List<Schedule> scheduleList;
    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    private List<Feature> features;

    public Classroom() {
    }

    public Classroom(int location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", location=" + location +
                ", capacity=" + capacity +
                ", scheduleList=" + scheduleList +
                ", features=" + features +
                '}';
    }
}