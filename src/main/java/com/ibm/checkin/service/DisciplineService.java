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
}
