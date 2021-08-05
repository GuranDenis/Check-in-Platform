package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation,Long> {
}
