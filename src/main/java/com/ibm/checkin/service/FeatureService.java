package com.ibm.checkin.service;

import com.ibm.checkin.entity.Classroom;
import com.ibm.checkin.entity.Feature;
import com.ibm.checkin.repository.ClassroomRepository;
import com.ibm.checkin.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    private final FeatureRepository featureRepository;

    private final ClassroomRepository classroomRepository;

    @Autowired
    public FeatureService(FeatureRepository featureRepository, ClassroomRepository classroomRepository) {
        this.featureRepository = featureRepository;
        this.classroomRepository = classroomRepository;
    }

    public List<Feature> getFeatures() {
        return featureRepository.findAll();
    }

    public List<Feature> getFeaturesByName(String name) {
        return featureRepository.getFeaturesByName(name);
    }

    public void addFeature(Feature feature, Long classroom_id) {
        if (!classroomRepository.existsById(classroom_id))
            throw new IllegalStateException("Classroom with id " + classroom_id + " doesn't exist");
        Classroom classroom = classroomRepository.getById(classroom_id);
        feature.setClassroom(classroom);
        featureRepository.save(feature);
    }

    public void setClassroomId(Long feature_id, Long classroom_id) {
        if (!featureRepository.existsById(feature_id))
            throw new IllegalStateException("Feature with id " + feature_id + " doesn't exist");
        if (!classroomRepository.existsById(classroom_id))
            throw new IllegalStateException("Classroom with id " + classroom_id + " doesn't exist");
        Classroom classroom = classroomRepository.getById(classroom_id);
        Feature feature = featureRepository.getById(feature_id);
        feature.setClassroom(classroom);
        featureRepository.save(feature);
    }
}
