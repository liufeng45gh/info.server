package com.lucifer.model;

import java.util.Date;

public class JobApply {

	private Long id;
	
	private Long resume_id;
	
	private Long job_id;
	
	private Date created_at;
	
	private Date updated_at;
	
	private Integer is_ignore;
	
	private Resume resume;
	
	private Job job;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResume_id() {
		return resume_id;
	}

	public void setResume_id(Long resume_id) {
		this.resume_id = resume_id;
	}

	public Long getJob_id() {
		return job_id;
	}

	public void setJob_id(Long job_id) {
		this.job_id = job_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Integer getIs_ignore() {
		return is_ignore;
	}

	public void setIs_ignore(Integer is_ignore) {
		this.is_ignore = is_ignore;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
	
}
