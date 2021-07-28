package com.ibm.checkin.controller;

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

    @GetMapping("/id/{id}")
    public Classroom findClassroomById(@PathVariable("id") Long id){
        return classroomService.findByID(id);
    }

    @PostMapping("/add")
    public void addClassroom(@RequestBody Classroom classroom){
        classroomService.addClassroom(classroom);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClassroom(@PathVariable("id") Long id){
        classroomService.deleteClassroom(id);
    }

    @PutMapping("/set/id/{classroom_id}/discipline/{discipline_id}")
    public void setDisciplineId(
            @PathVariable("classroom_id") Long classroom_id,
            @PathVariable("discipline_id") Long discipline_id){
        classroomService.setDisciplineId(classroom_id, discipline_id);
    }
}
