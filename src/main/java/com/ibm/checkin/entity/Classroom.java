package com.ibm.checkin.entity;

import javax.persistence.*;

@Table(name = "classrooms")
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long discipline_id;
    @Column(nullable = false)
    private int location;
    @Column(nullable = false)
    private int capacity;

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

    public Long getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(Long discipline_id) {
        this.discipline_id = discipline_id;
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

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", discipline_id=" + discipline_id +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
