package com.kranthi.JobApp2.controller;

import com.kranthi.JobApp2.model.Job;
import com.kranthi.JobApp2.repository.JobRepo;
import com.kranthi.JobApp2.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HomeController {
    @Autowired
    JobService service;
    @GetMapping("jobs")

    public List<Job> getAllJobs(){
        return service.getAllJobsList();

    }
    @GetMapping("jobs/{postId}")
    public Job getJob(@PathVariable String postId){
        return service.getjob(postId);
    }

    @PostMapping("/jobs")
    public Job setJob( @RequestBody Job job){
        service.addJob(job);
        return service.getjob(job.getPostId());
    }
    @PutMapping("/jobs")
    public Job updateJob(@RequestBody Job job){
        service.updateJob(job);
        return service.getjob(job.getPostId());
    }

    @DeleteMapping("/jobs/{postId}")
    public Job deleteJob(@PathVariable String postId){
        Job job = service.getjob(postId);
        service.deleteJob(postId);
        return job;

    }

    @GetMapping("load")
    public void loadJobs(){
        service.load();
    }

    @GetMapping("/jobs/keyword/{keyword}")
    public List<Job> search(@PathVariable String keyword){
        return service.search(keyword);

    }

}
