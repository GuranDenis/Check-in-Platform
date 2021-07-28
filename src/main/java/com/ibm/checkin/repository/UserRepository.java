package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Role;
import com.ibm.checkin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUsersByRole(Role role);
    User findUserById(Long id);
}
