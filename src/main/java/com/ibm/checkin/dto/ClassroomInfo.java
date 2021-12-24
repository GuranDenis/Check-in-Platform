package com.ibm.checkin.dto;

public class ClassroomInfo {

    private Long id;
    private int location;

    public ClassroomInfo(Long id, int location) {
        this.id = id;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
