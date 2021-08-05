package com.ibm.checkin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allocations")
public class Allocation {

    @Id
    private Long classroom_id;
    private Long discipline_id;

    public Allocation() {
    }

    public Allocation(Long classroom_id, Long discipline_id) {
        this.classroom_id = classroom_id;
        this.discipline_id = discipline_id;
    }

    public Long getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(Long classroom_id) {
        this.classroom_id = classroom_id;
    }

    public Long getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(Long discipline_id) {
        this.discipline_id = discipline_id;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "classroom_id=" + classroom_id +
                ", discipline_id=" + discipline_id +
                '}';
    }
}
