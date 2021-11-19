package com.ibm.checkin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table(name = "schedule")
@Entity(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "discipline_id", referencedColumnName = "id")
    private Discipline discipline;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private Classroom classroom;
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
    private String startDay;

    public Schedule() {
    }

    public Schedule(Discipline discipline, Classroom classroom, LocalDateTime startTime) {
        this.discipline = discipline;
        this.classroom = classroom;
        this.startTime = startTime;
        this.startDay = startTime.format(DateTimeFormatter.ofPattern("EEE"));
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", discipline=" + discipline +
                ", classroom=" + classroom +
                ", startTime=" + startTime +
                '}';
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }
}
