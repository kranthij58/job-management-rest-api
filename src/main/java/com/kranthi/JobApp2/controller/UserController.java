package com.kranthi.JobApp2.controller;

import com.kranthi.JobApp2.model.User;
import com.kranthi.JobApp2.service.JwtService;
import com.kranthi.JobApp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    @PostMapping("/register-user")
    public User register(@RequestBody User user){
        service.setUser(user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user);
        }
        return "Login Failed";
    }
}
