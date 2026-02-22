package com.kranthi.JobApp2.repository;

import com.kranthi.JobApp2.model.Job;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class JobRepo {
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

    public void addJob(Job job){
        jobList.add(job);
    }

    public Job getjob(String postId){
        for (Job job : jobList){
            if(job.getPostId().equals(postId)){
                return job;
            }
        }
        return null;
    }

    public boolean updateJob(Job job){
        for(Job j : jobList){
            if(j.getPostId().equals(job.getPostId())){
                j.setPostProfile(job.getPostProfile());
                j.setPostDesc(job.getPostDesc());
                j.setPostTechStack(job.getPostTechStack());
                j.setReqExperience(job.getReqExperience());
                return true;
            }

        }
        return false;
    }

    public boolean deleteJob(String postId){
        for(Job j : jobList){
            if(j.getPostId().equals(postId)){
                jobList.remove(j);
                return true;
            }
        }
        return false;
    }


    public List<Job> getAllJobsList() {
        return jobList;
    }
}
