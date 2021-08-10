package com.ibm.checkin.controller;

import com.ibm.checkin.entity.Role;
import com.ibm.checkin.entity.User;
import com.ibm.checkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/role/{role}")
    public List<User> findUsersByRole(@PathVariable("role") Role role){
        return userService.findByRole(role);
    }

    @GetMapping("/id/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return userService.findByID(id);
    }

    @PostMapping()
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

}
