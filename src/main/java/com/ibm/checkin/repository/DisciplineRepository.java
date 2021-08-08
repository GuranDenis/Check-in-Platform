package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    Discipline findDisciplineById(Long id);
    List<Discipline> getDisciplinesByName(String name);
}
