package com.kranthi.JobApp2.controller;

import com.kranthi.JobApp2.model.Job;
import com.kranthi.JobApp2.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HomeController {
    @Autowired
    JobRepo jobs;
    @GetMapping("jobs")

    public List<Job> getAllJobs(){
        return jobs.getJobList();

    }
    @GetMapping("jobs/{postId}")
    public Job getJob(@PathVariable String postId){
        return jobs.getjob(postId);
    }

    @PostMapping("/jobs")
    public Job setJob( @RequestBody Job job){
        jobs.addJob(job);
        return jobs.getjob(job.getPostId());
    }
    @PutMapping("/jobs")
    public Job updateJob(@RequestBody Job job){
        jobs.updateJob(job);
        return jobs.getjob(job.getPostId());
    }

    @DeleteMapping("/jobs/{postId}")
    public Job deleteJob(@PathVariable String postId){
        Job job = jobs.getjob(postId);
        jobs.deleteJob(postId);
        return job;

    }
}
