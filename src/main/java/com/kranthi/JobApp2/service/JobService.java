package com.kranthi.JobApp2.service;

import com.kranthi.JobApp2.model.Job;
import com.kranthi.JobApp2.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepo repo;
    public void addJob(Job job){
        System.out.println("add");
        repo.addJob(job);
    }

    public Job getjob(String postId){
        System.out.println("get");
       return repo.getjob(postId);
    }

    public boolean updateJob(Job job){
        System.out.println("update");
       return repo.updateJob(job);
    }

    public boolean deleteJob(String postId){
        System.out.println("delete");
        return repo.deleteJob(postId);
    }

    public List<Job> getAllJobsList() {
        System.out.println("All jobs");
        return repo.getAllJobsList();
    }

}
