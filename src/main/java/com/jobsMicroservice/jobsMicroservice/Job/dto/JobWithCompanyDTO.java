package com.jobsMicroservice.jobsMicroservice.Job.dto;

import com.jobsMicroservice.jobsMicroservice.Job.Job;
import com.jobsMicroservice.jobsMicroservice.Job.external.Company;

public class JobWithCompanyDTO {
    private Job job;
    private Company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
