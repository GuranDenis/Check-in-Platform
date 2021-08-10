package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> getScheduleByDisciplineId(Long disciplineId);
}
