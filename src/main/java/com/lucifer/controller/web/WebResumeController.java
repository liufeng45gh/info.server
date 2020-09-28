package com.lucifer.controller.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucifer.dao.CityDao;
import com.lucifer.dao.IndustryDao;
import com.lucifer.dao.PositionDao;
import com.lucifer.dao.ResumeDao;
import com.lucifer.dao.UserDao;
import com.lucifer.model.Certificate;
import com.lucifer.model.City;
import com.lucifer.model.EducationExperience;
import com.lucifer.model.Expand;
import com.lucifer.model.Industry;
import com.lucifer.model.JobExperience;
import com.lucifer.model.Language;
import com.lucifer.model.Position;
import com.lucifer.model.ProjectExperience;
import com.lucifer.model.Resume;
import com.lucifer.model.Train;
import com.lucifer.model.User;
import com.lucifer.service.SearchService;
import com.lucifer.util.StringUtil;

@Controller
public class WebResumeController {

	@Resource
	private IndustryDao industryDao;
	
	@Resource
	private PositionDao positionDao;
	
	@Resource
	private CityDao cityDao;
	
	@Resource
	private SearchService searchService;
	
	@Resource
	private ResumeDao resumeDao;
	
	@Resource
	private UserDao userDao;
	
	@RequestMapping(value = "/resume", method = RequestMethod.GET)
	public String index(Resume resume,@RequestParam(required=false,defaultValue="1") Integer page,HttpServletRequest request) throws SolrServerException {
		if (!StringUtil.isEmpty(resume.getIndustry_id())) {
			Industry industry = industryDao.getIndustry(resume.getIndustry_id());
			resume.setIndustry(industry);
		}
		
		if (!StringUtil.isEmpty(resume.getPosition_id()) ) {
			Position position = positionDao.getPosition(resume.getPosition_id());
			resume.setPosition(position);
		}
		
		if (!StringUtil.isEmpty(resume.getCity_id())) {
			City city = cityDao.getCity(resume.getCity_id());
			resume.setCity(city);
			if (null != city) {
				City parentCity = cityDao.getCity(city.getParent_id());
				resume.setParentCity(parentCity);
			}			
		}
		request.setAttribute("resume", resume);	
		Integer rows = 50;
		Integer offset = (page-1)*rows;
		List<Resume> resumtList = searchService.resumeSearch(resume.getTitle(), offset, rows, resume.getCity_id(), resume.getPosition_id(), resume.getIndustry_id());
		request.setAttribute("resumtList", resumtList);
		return "/WEB-INF/web/resume/index.jsp";
	}
	
	@RequestMapping(value = "/resume/{id}", method = RequestMethod.GET)
	public String show(@PathVariable Long id,HttpServletRequest request){
		
		Resume resume = resumeDao.get(id);
		request.setAttribute("resume", resume);
		
		User user = userDao.get(resume.getUser_id());
		request.setAttribute("user", user);
		
		Industry industry = industryDao.getIndustry(resume.getIndustry_id());
		resume.setIndustry(industry);
		
		Position position = positionDao.getPosition(resume.getPosition_id());
		resume.setPosition(position);
		
		City city = cityDao.getCity(resume.getCity_id());
		resume.setCity(city);
		
		City parentCity = cityDao.getCity(city.getParent_id());
		resume.setParentCity(parentCity);
		
		List<JobExperience> resumeJobExperienceList = resumeDao.resumeJobExprienceList(id);
		request.setAttribute("resumeJobExperienceList", resumeJobExperienceList);
		
		List <ProjectExperience> resumeProjectExperienceList = resumeDao.resumeProjectExperienceList(id);
		request.setAttribute("resumeProjectExperienceList", resumeProjectExperienceList);
		
		List <EducationExperience> resumeEducationExperienceList = resumeDao.resumeEducationExperienceList(id);
		request.setAttribute("resumeEducationExperienceList", resumeEducationExperienceList);
		
		List <Train> resumeTrainList = resumeDao.resumeTrainList(id);
		request.setAttribute("resumeTrainList", resumeTrainList);
		
		List<Certificate> resumeCertificateList = resumeDao.resumeCertificateList(id);
		request.setAttribute("resumeCertificateList", resumeCertificateList);
		
		List<Language> resumeLanguageList = resumeDao.resumeLanguageList(id);
		request.setAttribute("resumeLanguageList", resumeLanguageList);
		
		List<Expand> resumeExpandList = resumeDao.resumeExpandList(id);
		request.setAttribute("resumeExpandList", resumeExpandList);
		
		return "/WEB-INF/web/resume/show.jsp";
	}
}
