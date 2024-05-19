package com.jobsMicroservice.jobsMicroservice.Job.impl;

import com.jobsMicroservice.jobsMicroservice.Job.Job;
import com.jobsMicroservice.jobsMicroservice.Job.JobRepository;
import com.jobsMicroservice.jobsMicroservice.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class jobServiceImplementation implements JobService {

//    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public jobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }


    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setLocation(updateJob.getLocation());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setMinSalary(updateJob.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }


}
