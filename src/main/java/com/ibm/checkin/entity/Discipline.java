package com.ibm.checkin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "disciplines")
@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private Long teacherId;
    @Column(nullable = false)
    private String faculty;
    @Column(nullable = false)
    private String section;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    private int semester;
    @Column(nullable = false)
    private int credits;
    @JsonIgnore
    @OneToMany(mappedBy = "discipline")
    private List<Schedule> timetable;

    public Discipline() {
    }

    public Discipline(String name, String faculty, String section, int year, int semester, int credits) {
        this.name = name;
        this.faculty = faculty;
        this.section = section;
        this.year = year;
        this.semester = semester;
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Schedule> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Schedule> timetable) {
        this.timetable = timetable;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherId=" + teacherId +
                ", faculty='" + faculty + '\'' +
                ", section='" + section + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", credits=" + credits +
                ", timetable=" + timetable +
                '}';
    }
}
