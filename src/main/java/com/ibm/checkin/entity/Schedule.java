package com.ibm.checkin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "schedule")
@Entity
public class Schedule {
    @Id
    private Long discipline_id;
    private Date start_time;
    private Date end_time;

    public Schedule() {
    }

    public Long getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(Long discipline_id) {
        this.discipline_id = discipline_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "discipline_id=" + discipline_id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
