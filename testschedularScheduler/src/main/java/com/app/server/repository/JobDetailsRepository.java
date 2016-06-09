package com.app.server.repository;
import com.app.shared.jobs.JobDetails;

import java.util.List;

public interface JobDetailsRepository {

	public abstract List<JobDetails> getAllJobs() throws Exception;

	public abstract void updateJobDetails(JobDetails jobDetails) throws Exception;
	
	public abstract List<JobDetails> getJobByBeanName(String beanName) throws Exception;


}
