package com.lucifer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lucifer.dao.JobDao;
import com.lucifer.model.Interview;
import com.lucifer.model.JobApply;

@Service
public class JobService {
	
	@Resource
	private JobDao jobDao;
	
	public Integer applyJobs(String jobIds,Long resume_id){
		String [] jobIdStrs = jobIds.split(",");
		for (String jobIdStr:jobIdStrs) {
			Long jobId = Long.valueOf(jobIdStr);
			jobDao.applyJob(jobId, resume_id);
		}
		return jobIdStrs.length;
		
	}
	
	public void sendInterviewInvitation(Long apply_id,String content){
		JobApply jobApply = jobDao.getJobApply(apply_id);
		Interview interview = new Interview();
		interview.setJob_id(jobApply.getJob_id());
		interview.setResume_id(jobApply.getResume_id());
		interview.setContent(content);
		jobDao.insertInterview(interview);
	}

}
