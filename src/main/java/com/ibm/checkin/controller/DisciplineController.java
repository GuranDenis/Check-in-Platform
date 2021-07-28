package com.ibm.checkin.controller;

import com.ibm.checkin.entity.Discipline;
import com.ibm.checkin.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/discipline")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/all")
    public List<Discipline> getDisciplines(){
        return disciplineService.getDisciplines();
    }

    @GetMapping("/id/{id}")
    public Discipline findDisciplineById(@PathVariable("id") Long id){
        return disciplineService.findByID(id);
    }

    @PostMapping("/add")
    public void addDiscipline(@RequestBody Discipline discipline){
        disciplineService.addDiscipline(discipline);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDiscipline(@PathVariable("id") Long id){
        disciplineService.deleteDiscipline(id);
    }

    @PutMapping("/set/id/{discipline_id}/teacher/{teacher_id}")
    public void setTeacherId(
            @PathVariable("discipline_id") Long discipline_id,
            @PathVariable("teacher_id") Long teacher_id){
        disciplineService.setTeacherId(discipline_id, teacher_id);
    }
    
}
