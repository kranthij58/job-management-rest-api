package com.kranthi.JobApp2.service;

import com.kranthi.JobApp2.model.Job;
import com.kranthi.JobApp2.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepo repo;
    public void addJob(Job job){
        System.out.println("add");
        repo.save(job);
    }

    public Job getjob(String postId){
        System.out.println("get");
       return (Job) repo.findById(postId).orElse(new Job());
    }

    public boolean updateJob(Job job){
        System.out.println("update");
        repo.save(job);
        return true;
    }

    public boolean deleteJob(String postId){
        System.out.println("delete");
        Job job = repo.findById(postId).orElse(new Job());
        repo.delete(job);
        return true;
    }

    public List<Job> getAllJobsList() {
        System.out.println("All jobs");
       return repo.findAll();

    }
    public void load(){
        List<Job> jobList = new ArrayList<>(Arrays.asList(

        new Job("1", "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


        new Job("2", "Frontend Developer", "Experience in building responsive web applications using React", 3,
                List.of("HTML", "CSS", "JavaScript", "React")),


        new Job("3", "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")),


        new Job("4", "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")),


        new Job("5", "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                List.of("iOS Development", "Android Development", "Mobile App"))
));
        repo.saveAll(jobList);
    }

    public List<Job> search(String keyword){
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
