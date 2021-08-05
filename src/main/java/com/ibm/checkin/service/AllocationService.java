package com.ibm.checkin.service;

import com.ibm.checkin.entity.Allocation;
import com.ibm.checkin.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    private final AllocationRepository allocationRepository;

    @Autowired
    public AllocationService(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    public List<Allocation> getAllocations(){
        return allocationRepository.findAll();
    }
}
