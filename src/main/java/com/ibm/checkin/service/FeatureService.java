package com.ibm.checkin.service;

import com.ibm.checkin.entity.Classroom;
import com.ibm.checkin.entity.Feature;
import com.ibm.checkin.repository.ClassroomRepository;
import com.ibm.checkin.repository.FeatureRepository;
import com.ibm.checkin.request.FeatureRequest;
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

    public List<Classroom> getFeaturesByClassroomId(Long classroomId) {
        return featureRepository.getFeaturesByClassroomId(classroomId);
    }

    public void updateClassroomId(Long featureId, Long classroomId) {
        if (!featureRepository.existsById(featureId))
            throw new IllegalStateException("Feature with id " + featureId + " doesn't exist");
        if (!classroomRepository.existsById(classroomId))
            throw new IllegalStateException("Classroom with id " + classroomId + " doesn't exist");
        Feature feature = featureRepository.getById(featureId);
        feature.setClassroom(classroomRepository.getById(classroomId));
        featureRepository.save(feature);
    }

    public void addFeature(FeatureRequest featureRequest) {
        Long classroomId = featureRequest.getClassroomId();
        if (!classroomRepository.existsById(classroomId))
            throw new IllegalStateException("Classroom with id " + classroomId + " doesn't exist");
        Feature feature = new Feature(
                classroomRepository.getById(classroomId),
                featureRequest.getName()
        );

        for (Feature featureObject:featureRepository.getFeaturesByName(feature.getName()))
                if(featureObject.getClassroom().equals(feature.getClassroom()))
                    throw new IllegalStateException("Feature already added to classroom with id " + feature.getClassroom().getId());

        featureRepository.save(feature);
    }

    public void deteleFeatureById(Long featureId) {
        if (!featureRepository.existsById(featureId))
            throw new IllegalStateException("Feature with id " + featureId + " doesn't exist");
        featureRepository.deleteById(featureId);
    }
}
