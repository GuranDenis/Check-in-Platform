package com.ibm.checkin.controller;

import com.ibm.checkin.entity.Classroom;
import com.ibm.checkin.entity.Feature;
import com.ibm.checkin.request.FeatureRequest;
import com.ibm.checkin.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/feature")
public class FeatureController {

    private final FeatureService featureService;

    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping("/all")
    public List<Feature> getFeatures(){
        return featureService.getFeatures();
    }

    @GetMapping("/name/{name}")
    public List<Feature> getFeatureByName(@PathVariable(name = "name") String name){
        return featureService.getFeatureByName(name);
    }

    @GetMapping("classroom/{classroom_id}")
    public List<Classroom> getFeaturesByClassroomId(@PathVariable(name = "classroom_id") Long classroomId){
        return featureService.getFeaturesByClassroomId(classroomId);
    }

    @PostMapping
    public void addFeature(@RequestBody FeatureRequest featureRequest){
        featureService.addFeature(featureRequest);
    }

    @PutMapping("/id/{feature_id}/classroom/{classroom_id}")
    public void updateClassroomId(
            @PathVariable("feature_id") Long featureId,
            @PathVariable("classroom_id") Long classroomId){
        featureService.updateClassroomId(featureId, classroomId);
    }

    @DeleteMapping("/id/{feature_id}")
    public void deleteFeatureById(@PathVariable("feature_id") Long featureId){
        featureService.deteleFeatureById(featureId);
    }


}
