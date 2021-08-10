package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Classroom;
import com.ibm.checkin.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    List<Feature> getFeatureByName(String name);
    List<Classroom> getFeaturesByClassroomId(Long classroomId);
}
