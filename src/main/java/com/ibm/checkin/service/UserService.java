package com.ibm.checkin.service;

import com.ibm.checkin.entity.Role;
import com.ibm.checkin.entity.User;
import com.ibm.checkin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> findByRole(Role role) {
        return userRepository.findUsersByRole(role);
    }

    public User findByID(Long id) {
        if(!userRepository.existsById(id))
            throw new IllegalStateException("User with id " + id + " doesn't exist.");
        return userRepository.findUsersById(id);
    }

    public void deleteUser(Long id) {
        if(!userRepository.existsById(id))
            throw new IllegalStateException("User with id " + id + " doesn't exist.");
        userRepository.deleteById(id);
    }
}
