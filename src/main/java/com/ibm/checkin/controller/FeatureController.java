package com.ibm.checkin.controller;

import com.ibm.checkin.entity.Feature;
import com.ibm.checkin.entity.Schedule;
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
    public List<Feature> getFeaturesByName(@PathVariable(name = "name") String name){
        return featureService.getFeaturesByName(name);
    }

    @PostMapping("/classroom/{classroom_id}")
    public void addSchedule(@RequestBody Feature feature,
                            @PathVariable(name = "classroom_id") Long classroom_id){
        featureService.addFeature(feature,classroom_id);
    }

    @PutMapping("/id/{feature_id}/classroom/{classroom_id}")
    public void setClassroomId(
            @PathVariable("feature_id") Long feature_id,
            @PathVariable("classroom_id") Long classroom_id){
        featureService.setClassroomId(feature_id, classroom_id);
    }

}
