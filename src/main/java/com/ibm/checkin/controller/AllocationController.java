package com.ibm.checkin.controller;

import com.ibm.checkin.entity.Allocation;
import com.ibm.checkin.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/allocation")
public class AllocationController {

    private final AllocationService allocationService;

    @Autowired
    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @GetMapping("/all")
    public List<Allocation> getAllocations(){
        return allocationService.getAllocations();
    }
}
