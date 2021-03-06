package com.ibm.checkin.service;

import com.ibm.checkin.dto.ClassroomInfo;
import com.ibm.checkin.entity.Classroom;
import com.ibm.checkin.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getClassrooms(){
        return classroomRepository.findAll();
    }

    public Classroom findByID(Long id) {
        if(!classroomRepository.existsById(id))
            throw new IllegalStateException("Classroom with id " + id + " doesn't exist");
        return classroomRepository.findClassroomById(id);
    }

    public void addClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public void deleteClassroom(Long id) {
        if(!classroomRepository.existsById(id))
            throw new IllegalStateException("Classroom with id " + id + " doesn't exist");
        classroomRepository.deleteById(id);
    }

    public List<ClassroomInfo> getClassroomInfo() {
        List<Classroom> classrooms = classroomRepository.findAll();
        List<ClassroomInfo> locations = new ArrayList<>();
        for(Classroom classroom :  classrooms)
            locations.add(new ClassroomInfo(classroom.getId(), classroom.getLocation()));
        return locations;
    }
}
