package com.ibm.checkin.request;

public class FeatureRequest {

    private String name;
    private Long classroomId;

    public FeatureRequest() {
    }

    public FeatureRequest(String name, Long classroomId) {
        this.name = name;
        this.classroomId = classroomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }
}
