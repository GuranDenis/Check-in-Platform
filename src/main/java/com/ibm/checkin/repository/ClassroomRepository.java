package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository  extends JpaRepository<Classroom,Long> {
    Classroom findClassroomById(Long id);
}
