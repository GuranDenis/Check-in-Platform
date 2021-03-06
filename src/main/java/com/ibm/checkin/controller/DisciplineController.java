package com.ibm.checkin.controller;

import com.ibm.checkin.dto.DisciplineInfo;
import com.ibm.checkin.entity.Discipline;
import com.ibm.checkin.repository.DisciplineRepository;
import com.ibm.checkin.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @GetMapping("/names")
    public List<DisciplineInfo> getDisciplineInfo(){
        return disciplineService.getDisciplineInfo();
    }

    @GetMapping("/id/{id}")
    public Discipline findDisciplineById(@PathVariable("id") Long id){
        return disciplineService.findByID(id);
    }

    @GetMapping("/dto")
    public List<DisciplineRepository.DisciplineDTO> getDisciplinesDTO(){
        return disciplineService.getDisciplinesDTO();
    }

    @GetMapping("/dto/{day}")
    public List<DisciplineRepository.DisciplineDTO> getDisciplinesDTOByDay(@PathVariable("day") String day){
        return disciplineService.getDisciplinesDTOByDay(day);
    }

    @PostMapping()
    public void addDiscipline(@RequestBody Discipline discipline){
        disciplineService.addDiscipline(discipline);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscipline(@PathVariable("id") Long id){
        disciplineService.deleteDiscipline(id);
    }

    @PutMapping("/id/{discipline_id}/teacher/{teacher_id}")
    public void setTeacherId(
            @PathVariable("discipline_id") Long discipline_id,
            @PathVariable("teacher_id") Long teacher_id){
        disciplineService.setTeacherId(discipline_id, teacher_id);
    }
    
}
