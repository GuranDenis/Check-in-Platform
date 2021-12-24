package com.ibm.checkin.controller;

import com.ibm.checkin.dto.ClassroomInfo;
import com.ibm.checkin.entity.Classroom;
import com.ibm.checkin.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/all")
    public List<Classroom> getClassrooms(){
        return classroomService.getClassrooms();
    }

    @GetMapping("/locations")
    public List<ClassroomInfo> getClassroomInfo(){
        return classroomService.getClassroomInfo();
    }

    @GetMapping("/id/{id}")
    public Classroom findClassroomById(@PathVariable("id") Long id){
        return classroomService.findByID(id);
    }

    @PostMapping()
    public void addClassroom(@RequestBody Classroom classroom){
        classroomService.addClassroom(classroom);
    }

    @DeleteMapping("/id/{id}")
    public void deleteClassroom(@PathVariable("id") Long id){
        classroomService.deleteClassroom(id);
    }
}
