package com.lucifer.controller.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucifer.dao.CityDao;
import com.lucifer.dao.IndustryDao;
import com.lucifer.dao.PositionDao;
import com.lucifer.dao.ResumeDao;
import com.lucifer.dao.UserDao;
import com.lucifer.dao.JobDao;
import com.lucifer.model.City;
import com.lucifer.model.Company;
import com.lucifer.model.Industry;
import com.lucifer.model.Job;
import com.lucifer.model.JobApply;
import com.lucifer.model.Position;
import com.lucifer.model.Resume;
import com.lucifer.model.User;
import com.lucifer.service.JobService;
import com.lucifer.util.Result;
import com.lucifer.util.ViewHelper;

@Controller
public class ManageJobController {

	@Resource
	private JobDao jobDao;
	
	@Resource
	private IndustryDao industryDao;
	
	@Resource
	private PositionDao positionDao;
		
	@Resource
	private CityDao cityDao;
	
	@Resource
	private ResumeDao resumeDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private JobService jobService;
	
	@RequestMapping(value = "/manage/recruitment/list", method = RequestMethod.GET)
	public String index(){
		return "/WEB-INF/web/manage/recruitment/list.jsp";
	}
	
	@RequestMapping(value = "/manage/recruitment/company", method = RequestMethod.GET)
	public String company(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		Company company = jobDao.getUserCompany(user.getId());
		request.setAttribute("company", company);
		
		Industry industry = industryDao.getIndustry(company.getIndustry_id());
		company.setIndustry(industry);
		return "/WEB-INF/web/manage/recruitment/companySurface.jsp";
	}
	
	@RequestMapping(value = "/manage/recruitment/company_init", method = RequestMethod.GET)
	public String companyInit(HttpServletRequest request){		
		this.company(request);
		return "/WEB-INF/web/manage/recruitment/companyInitSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/recruitment/company_init", method = RequestMethod.POST)
	public String companyInitSubmit(Company company,HttpServletRequest request){
		this.companyUpdateSubmit(company,request);
		return "redirect:/manage/job/add";
	}
	
	@RequestMapping(value = "/manage/recruitment/company", method = RequestMethod.POST)
	public String companyUpdateSubmit(Company company,HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		company.setUser_id(user.getId());
		jobDao.saveOrUpdateCompany(company);
		return "redirect:/manage/recruitment/company";
	}
	
	@RequestMapping(value = "/manage/job/add", method = RequestMethod.GET)
	public String jobAdd(HttpServletRequest request){
		
		User user = ViewHelper.getInstance().getWebTokenUser(request);		
		Company company = jobDao.getUserCompany(user.getId());
		if (null == company) {
			return "redirect:/manage/recruitment/company_init";
		}
		return "/WEB-INF/web/manage/recruitment/jobAdd.jsp";
	}
	
	@RequestMapping(value = "/manage/job/add", method = RequestMethod.POST)
	public String jobAddSubmit(Job job,HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		job.setUser_id(user.getId());
		
		jobDao.insertJob(job);
		return "redirect:/manage/job/list";
	}
	
	@RequestMapping(value = "/manage/job/list", method = RequestMethod.GET)
	public String jobList(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		List<Job> jobList = jobDao.userJobList(user.getId());
		request.setAttribute("jobList", jobList);
		for (Job job :jobList) {
			Position position = positionDao.getPosition(job.getPosition_id());
			job.setPosition(position);
			
			City city = cityDao.getCity(job.getCity_id());
			job.setCity(city);
		}
		return "/WEB-INF/web/manage/recruitment/jobList.jsp";
	}
	
	@RequestMapping(value = "/manage/job/refresh", method = RequestMethod.POST)
	@ResponseBody
	public Result refresh(Long id){
		jobDao.refreshJob(id);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/job/update", method = RequestMethod.GET)
	public String jobUpdateInput(Long id,HttpServletRequest request) throws Exception{
		Job job = jobDao.getJob(id);
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		if (!job.getUser_id().equals(user.getId())) {
			throw new Exception("you have not allow to edit");
		}
		request.setAttribute("job", job);
		Position position = positionDao.getPosition(job.getPosition_id());
		job.setPosition(position);
		
		Industry industry = industryDao.getIndustry(job.getIndustry_id());
		job.setIndustry(industry);
		
		City city = cityDao.getCity(job.getCity_id());
		job.setCity(city);
		
		City parentCity = cityDao.getCity(city.getParent_id());
		job.setParentCity(parentCity);
		return "/WEB-INF/web/manage/recruitment/jobUpdate.jsp";
	}
	
	@RequestMapping(value = "/manage/job/update", method = RequestMethod.POST)
	public String jobUpdateSubmit(Job job){
		jobDao.updateJob(job);
		return "redirect:/manage/job/update?id="+job.getId();
	}
	
	@RequestMapping(value = "/manage/job/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result deleteJob(Long id,HttpServletRequest request) throws Exception{
		Job job = jobDao.getJob(id);
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		if (!job.getUser_id().equals(user.getId())) {
			throw new Exception("you have not allow to edit");
		}
		jobDao.deleteJob(id);
		return Result.ok();
		
	}
	
	
	@RequestMapping(value = "/manage/job/received-resumes", method = RequestMethod.GET)
	public String myReceivedResumeList(@RequestParam(required=false,defaultValue="1") Integer page,HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		List<JobApply> jobApplyList = jobDao.userReceivedResumeList(page, user.getId());
		for (JobApply jobApply:jobApplyList) {
			Resume resume = resumeDao.get(jobApply.getResume_id());
			User resumeUser = userDao.get(resume.getUser_id());
			resume.setUser(resumeUser);
			jobApply.setResume(resume);
		}
		request.setAttribute("jobApplyList", jobApplyList);
		return "/WEB-INF/web/manage/recruitment/myReceivedResumeList.jsp";
	}
	
	@RequestMapping(value = "/manage/job/ignore-resume", method = RequestMethod.POST)
	@ResponseBody
	public Result ignoreResume(Long apply_id,HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		jobDao.ignoreResume(apply_id);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/job/send-interview", method = RequestMethod.POST)
	@ResponseBody	
	public Result sendInterviewInvitation(Long apply_id,HttpServletRequest request,String content){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		jobService.sendInterviewInvitation(apply_id, content);
		return Result.ok();
		
	}
}
