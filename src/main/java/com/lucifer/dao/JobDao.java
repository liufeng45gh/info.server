package com.lucifer.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lucifer.dao.base.IBatisBaseDao;
import com.lucifer.model.Company;
import com.lucifer.model.Interview;
import com.lucifer.model.Job;
import com.lucifer.model.JobApply;
import com.lucifer.model.Resume;
import com.lucifer.util.CommonUtil;

@Service
public class JobDao  extends IBatisBaseDao{

	public void saveOrUpdateCompany(Company company){
		if (null == company.getId()) {
			this.insertCompany(company);
		} else {
			this.updateCompany(company);
		}
	}
	
	private Integer insertCompany(Company company){
		company.setId(CommonUtil.nextId());
		return sqlSession.insert("insertCompany", company);
	}
	
	private Integer updateCompany(Company company){
		return sqlSession.update("updateCompany", company);
	}
	
	public Company getUserCompany(Long user_id){
		return (Company)sqlSession.selectOne("getUserCompany", user_id);
	}
	
	public Integer insertJob(Job job){
		job.setId(CommonUtil.nextId());
		return sqlSession.insert("insertJob", job);
	}
	
	public List<Job> userJobList(Long user_id){
		@SuppressWarnings("unchecked")
		List<Job> list = sqlSession.selectList("userJobList", user_id);
		return list;
	}
	
	public Integer refreshJob(Long id){
		return sqlSession.update("refreshJob", id);
	}
	
	public Job getJob(Long id){
		return (Job)sqlSession.selectOne("getJob", id);
	}
	
	public Integer updateJob(Job job){
		return sqlSession.update("updateJob", job);
	}
	
	public Integer deleteJob(Long id){
		return sqlSession.delete("deleteJob", id);
	}
	
	public List<Job> jobListOrderByUpdatedAt(Date updated_at,int count){
		Map param = new HashMap();
		param.put("updated_at", updated_at);
		param.put("count", count);
		return  sqlSession.selectList("jobListOrderByUpdatedAt", param);
	}
	
	public void applyJob(Long job_id,Long resume_id){
		Map param = new HashMap();
		param.put("id", CommonUtil.nextId());
		param.put("job_id", job_id);
		param.put("resume_id", resume_id);
		sqlSession.insert("applyJob",param);
	}
	
	public List<JobApply> userReceivedResumeList(Integer page,Long user_id){
		Integer count = 20;
		Integer offset = (page-1)*count;
		Map param = new HashMap();
		param.put("offset", offset);
		param.put("count", count);
		param.put("user_id", user_id);
		return  sqlSession.selectList("userReceivedResumeList", param);
	}
	
	public Integer ignoreResume(Long apply_id){
		return  sqlSession.update("ignoreResume",apply_id);
	}
	
	public JobApply getJobApply(Long apply_id){
		return  (JobApply)sqlSession.selectOne("getJobApply",apply_id);	
	}
	
	public Integer insertInterview(Interview interview){
		interview.setId(CommonUtil.nextId());
		interview.setCreated_at(new Date());
		interview.setUpdated_at(new Date());
		return sqlSession.insert("insertInterview",interview);
	}
}
