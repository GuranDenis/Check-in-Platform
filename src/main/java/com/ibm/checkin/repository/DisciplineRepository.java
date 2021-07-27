package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
