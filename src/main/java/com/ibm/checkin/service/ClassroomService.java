package com.ibm.checkin.service;

import com.ibm.checkin.entity.Classroom;
import com.ibm.checkin.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}