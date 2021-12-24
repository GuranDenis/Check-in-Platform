package com.ibm.checkin.request;

import java.time.LocalDateTime;

public class ScheduleRequest {

    private Long disciplineId;
    private Long classroomId;
    private LocalDateTime startTime;

    public ScheduleRequest() {
    }

    public ScheduleRequest(Long disciplineId, Long classroomId, LocalDateTime startTime) {
        this.disciplineId = disciplineId;
        this.classroomId = classroomId;
        this.startTime = startTime;
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

}
