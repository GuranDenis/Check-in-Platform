package com.ibm.checkin.entity;

import javax.persistence.*;

@Table(name = "disciplines")
@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private Long teacher_id;
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

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher_id=" + teacher_id +
                ", faculty='" + faculty + '\'' +
                ", section='" + section + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", credits=" + credits +
                '}';
    }
}
