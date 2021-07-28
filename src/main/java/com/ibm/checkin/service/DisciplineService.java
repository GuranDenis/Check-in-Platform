package com.ibm.checkin.service;

import com.ibm.checkin.entity.Discipline;
import com.ibm.checkin.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<Discipline> getDisciplines(){
        return disciplineRepository.findAll();
    }

    public Discipline findByID(Long id) {
        if(!disciplineRepository.existsById(id))
            throw new IllegalStateException("Discipline with id " + id + " doesn't exist");
        return disciplineRepository.findDisciplineById(id);
    }

    public void addDiscipline(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    public void deleteDiscipline(Long id) {
        if(!disciplineRepository.existsById(id))
            throw new IllegalStateException("Discipline with id " + id + " doesn't exist");
        disciplineRepository.deleteById(id);
    }

    public void setTeacherId(Long discipline_id, Long teacher_id) {
        if(!disciplineRepository.existsById(discipline_id))
            throw new IllegalStateException("Discipline with id " + discipline_id + " doesn't exist");
        Discipline discipline = disciplineRepository.getById(discipline_id);
        discipline.setTeacher_id(teacher_id);
        disciplineRepository.save(discipline);
    }
}
