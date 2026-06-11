package com.kranthi.JobApp2.controller;

import com.kranthi.JobApp2.model.User;
import com.kranthi.JobApp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;
    @PostMapping("/register-user")
    public User register(@RequestBody User user){
        service.setUser(user);
        return user;
    }
}
