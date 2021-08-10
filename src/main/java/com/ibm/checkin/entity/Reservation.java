package com.ibm.checkin.entity;

import javax.persistence.*;

@Table(name = "reservations")
@Entity(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;

    public Reservation() {
    }

    public Reservation(Long studentId, Long scheduleId) {
        this.studentId = studentId;
        this.scheduleId = scheduleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", scheduleId=" + scheduleId +
                '}';
    }
}
