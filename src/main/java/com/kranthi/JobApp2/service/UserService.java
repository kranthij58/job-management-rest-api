package com.kranthi.JobApp2.service;


import com.kranthi.JobApp2.model.User;
import com.kranthi.JobApp2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public void setUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);

    }
}
