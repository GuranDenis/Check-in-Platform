package com.ibm.checkin.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScheduleRequestUpdate {

    private Long id;
    private Long disciplineId;
    private Long classroomId;
    private LocalDate day;
    private LocalTime time;
    private LocalDateTime startTime;

    public ScheduleRequestUpdate(Long id, Long disciplineId, Long classroomId, LocalDate day, LocalTime time) {
        this.id = id;
        this.disciplineId = disciplineId;
        this.classroomId = classroomId;
        this.day = day;
        this.time = time;
        this.startTime = LocalDateTime.of(day.getYear(),day.getMonth(),day.getDayOfMonth(),time.getHour(),time.getMinute());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}