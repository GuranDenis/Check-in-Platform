package com.ibm.checkin.dto;

import java.time.LocalDateTime;

public class DisciplineDTO {

    private Long scheduleId;
    private Long disciplineId;
    private Long classroomId;
    private LocalDateTime startTime;
    private String disciplineName;
    private int classroomLocation;
    private String teacherFirstName;
    private String teacherLastName;
    private int capacity;
    private Long enrolledStudentsNumber;

    public DisciplineDTO() {
    }

    public DisciplineDTO(Long scheduleId, Long disciplineId, Long classroomId, LocalDateTime startTime, String disciplineName, int classroomLocation, String teacherFirstName, String teacherLastName, int capacity, Long enrolledStudentsNumber) {
        this.scheduleId = scheduleId;
        this.disciplineId = disciplineId;
        this.classroomId = classroomId;
        this.startTime = startTime;
        this.disciplineName = disciplineName;
        this.classroomLocation = classroomLocation;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.capacity = capacity;
        this.enrolledStudentsNumber = enrolledStudentsNumber;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public int getClassroomLocation() {
        return classroomLocation;
    }

    public void setClassroomLocation(int classroomLocation) {
        this.classroomLocation = classroomLocation;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Long getEnrolledStudentsNumber() {
        return enrolledStudentsNumber;
    }

    public void setEnrolledStudentsNumber(Long enrolledStudentsNumber) {
        this.enrolledStudentsNumber = enrolledStudentsNumber;
    }
}
