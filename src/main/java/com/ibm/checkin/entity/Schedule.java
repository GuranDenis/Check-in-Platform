package com.ibm.checkin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "discipline_id", referencedColumnName = "id")
    private Discipline discipline;

    public Schedule() {
    }

    public Schedule(LocalDateTime time, Discipline discipline) {
        this.time = time;
        this.discipline = discipline;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", time=" + time +
                ", discipline=" + discipline +
                '}';
    }
}
