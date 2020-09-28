package com.lucifer.controller.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.lucifer.model.Interview;
import com.lucifer.model.JobApply;
import com.lucifer.model.JobExperience;
import com.lucifer.model.Language;
import com.lucifer.model.Position;
import com.lucifer.model.ProjectExperience;
import com.lucifer.model.Resume;
import com.lucifer.model.Train;
import com.lucifer.model.User;
import com.lucifer.service.ResumeService;
import com.lucifer.util.CommonUtil;
import com.lucifer.util.Result;
import com.lucifer.util.ViewHelper;

@Controller
public class ManageResumeController {
	
	@Resource
	private ResumeDao resumeDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private IndustryDao industryDao;
	
	@Resource
	private PositionDao positionDao;
	
	@Resource
	private CityDao cityDao;
	
	@Resource
	private ResumeService resumeService;
	
	private static  Log log = LogFactory.getLog(ManageResumeController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
	
	
	/**
	 * 简历首页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/list", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		List<Resume> resumeList = resumeDao.userResumeList(user.getId());
		request.setAttribute("user", user);
		request.setAttribute("resumeList", resumeList);
		log.info("resumeList size: "+resumeList.size());
		log.info("user.getId is "+user.getId());
		return "/WEB-INF/web/manage/resume/index.jsp";
	}
	
	/**
	 * 新增简历
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/add", method = RequestMethod.GET)
	public String resumeAddInput(HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		request.setAttribute("opt", "新增简历信息");
		return "/WEB-INF/web/manage/resume/resumeAdd.jsp";
	}
	
	/**
	 * 新增简历提交
	 * @param user
	 * @param resume
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/add", method = RequestMethod.POST)
	public String resumeAddSubmit(User user,Resume resume,HttpServletRequest request){
			
		User tokenUser = ViewHelper.getInstance().getWebTokenUser(request);
		tokenUser.setTelephone(user.getTelephone());
		tokenUser.setReal_name(user.getReal_name());
		tokenUser.setGender(user.getGender());
		tokenUser.setBirthday(user.getBirthday());
		tokenUser.setOrigin_place(user.getOrigin_place());
		tokenUser.setResidence(user.getResidence());
		userDao.updateUserInfo(tokenUser);
		
		resume.setId(CommonUtil.nextId());
		resume.setUser_id(tokenUser.getId());
		resumeDao.insert(resume);	
		
		return "redirect:/manage/resume/update?id="+resume.getId();
	}
	
	
	/**
	 * 修改简历
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/update", method = RequestMethod.GET)
	public String resumeUpdateInput(Long id,HttpServletRequest request){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		Resume resume = resumeDao.get(id);
		request.setAttribute("resume", resume);
		
		Industry industry = industryDao.getIndustry(resume.getIndustry_id());
		resume.setIndustry(industry);
		
		Position position = positionDao.getPosition(resume.getPosition_id());
		resume.setPosition(position);
		
		City city = cityDao.getCity(resume.getCity_id());
		resume.setCity(city);
		if (city != null) {
			City parentCity = cityDao.getCity(city.getParent_id());
			resume.setParentCity(parentCity);
		}
				
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
		
		return "/WEB-INF/web/manage/resume/resumeShow.jsp";
	}
	
	/**
	 * 修改简历基本信息
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/simpleUpdate", method = RequestMethod.GET)
	public String simpleInfoUpdateInput(){
		return "/WEB-INF/web/manage/resume/resumeAdd.jsp";
	}
	
	/**
	 * 修改简历基本信息提交
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/info/update", method = RequestMethod.GET)
	public String resumeInfoUpdate(Long id,HttpServletRequest request){
		
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		request.setAttribute("user", user);
		Resume resume = resumeDao.get(id);
		request.setAttribute("resume", resume);
		
		Industry industry = industryDao.getIndustry(resume.getIndustry_id());
		resume.setIndustry(industry);
		
		Position position = positionDao.getPosition(resume.getPosition_id());
		resume.setPosition(position);
		
		City city = cityDao.getCity(resume.getCity_id());
		resume.setCity(city);
		if (city != null) {
			City parentCity = cityDao.getCity(city.getParent_id());
			resume.setParentCity(parentCity);
		}
		
		
//		Education oevaluation = Education.objectOf(resume.getEvaluation());
//		resume.setOevaluation(oevaluation);
		
		request.setAttribute("opt", "修改简历基本信息");
		
		return "/WEB-INF/web/manage/resume/resumeInfoUpdateSurface.jsp";
	}
	
	/**
	 * 修改简历
	 * @param user
	 * @param resume
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/info/update", method = RequestMethod.POST)
	public String resumeInfoUpdateSubmit(User user,Resume resume,HttpServletRequest request){
		//resume.setId(CommonUtil.nextId());		
		User tokenUser = ViewHelper.getInstance().getWebTokenUser(request);
		tokenUser.setTelephone(user.getTelephone());
		tokenUser.setReal_name(user.getReal_name());
		tokenUser.setGender(user.getGender());
		tokenUser.setBirthday(user.getBirthday());
		tokenUser.setOrigin_place(user.getOrigin_place());
		tokenUser.setResidence(user.getResidence());
		userDao.updateUserInfo(tokenUser);
		resumeDao.updateResumeInfo(resume);	
		return "redirect:/manage/resume/update?id="+resume.getId();
	}
	
	/**
	 * 关闭简历
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/close", method = RequestMethod.POST)
	@ResponseBody
	public Result close(Long id){
		resumeDao.closeResume(id);
		return Result.ok();
	}
	
	/**
	 * 打开简历
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/open", method = RequestMethod.POST)
	@ResponseBody
	public Result open(Long id){
		resumeDao.openResume(id);
		return Result.ok();
	}
	
	/**
	 * 新增工作经验
	 * @param resume_id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/manage/resume/experence/add", method = RequestMethod.GET)
	public String experienceAddInput(Long resume_id,HttpServletRequest request){
		request.setAttribute("resume_id", resume_id);
		request.setAttribute("opt", "增加工作经验");
		return "/WEB-INF/web/manage/resume/resumeExperienceAddSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/experence/add", method = RequestMethod.POST)
	public String experienceAddSubmit(JobExperience jobExperience){
		jobExperience.setId(CommonUtil.nextId());
		resumeDao.insertExperence(jobExperience);
		return "redirect:/manage/resume/update?id="+jobExperience.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/job_experience/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result experienceDelete(Long id){
		resumeDao.deleteJobExperence(id);
		return Result.ok();
	}
	
	
	@RequestMapping(value = "/manage/resume/experence/update", method = RequestMethod.GET)
	public String modifyJobExperienceInput(Long id,HttpServletRequest request){
		JobExperience jobExperience = resumeDao.getJobExperience(id);
		request.setAttribute("jobExperience", jobExperience);
		request.setAttribute("opt", "修改工作经验");
		request.setAttribute("resume_id", jobExperience.getResume_id());
		return "/WEB-INF/web/manage/resume/resumeExperienceUpdateSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/experence/update", method = RequestMethod.POST)
	public String modifyJobExperienceSubmit(JobExperience jobExperience){
		resumeDao.updateJobExprience(jobExperience);
		return "redirect:/manage/resume/update?id="+jobExperience.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/project_experience/add", method = RequestMethod.GET)
	public String projectExperienceAdd(Long resume_id,HttpServletRequest request){
		request.setAttribute("opt", "增加项目经验");
		request.setAttribute("resume_id", resume_id);
		return "/WEB-INF/web/manage/resume/resumeProjectExperienceAddSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/project_experience/add", method = RequestMethod.POST)
	public String projectExperienceAddSubmit(ProjectExperience projectExperience){
		projectExperience.setId(CommonUtil.nextId());
		resumeDao.insertProjectExperience(projectExperience);
		return "redirect:/manage/resume/update?id="+projectExperience.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/project_experience/update", method = RequestMethod.GET)
	public String projectExperienceUpdate(Long id,HttpServletRequest request){
		request.setAttribute("opt", "修改项目经验");		
		ProjectExperience projectExperience = resumeDao.getProjectExperience(id);
		request.setAttribute("projectExperience", projectExperience);
		request.setAttribute("resume_id", projectExperience.getResume_id());
		return "/WEB-INF/web/manage/resume/resumeProjectExperienceUpdateSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/project_experience/update", method = RequestMethod.POST)
	public String modifyProjectExperienceSubmit(ProjectExperience projectExperience){
		resumeDao.updateProjectExperience(projectExperience);
		return "redirect:/manage/resume/update?id="+projectExperience.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/project_experience/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result projectExperienceDelete(Long id){
		resumeDao.deleteProjectExperence(id);
		return Result.ok();
	}
	
	
	@RequestMapping(value = "/manage/resume/education_experience/add", method = RequestMethod.GET)
	public String educationExperienceAdd(Long resume_id,HttpServletRequest request){
		request.setAttribute("opt", "增加教育经历");
		request.setAttribute("resume_id", resume_id);
		return "/WEB-INF/web/manage/resume/resumeEducationExperienceAddSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/education_experience/add", method = RequestMethod.POST)
	public String educationExperienceAddSubmit(EducationExperience educationExperience){
		educationExperience.setId(CommonUtil.nextId());
		resumeDao.insertEducationExperience(educationExperience);
		return "redirect:/manage/resume/update?id="+educationExperience.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/education_experience/update", method = RequestMethod.GET)
	public String educationExperienceUpdate(Long id,HttpServletRequest request){
		request.setAttribute("opt", "修改教育经历");		
		EducationExperience educationExperience = resumeDao.getEducationExperience(id);
		request.setAttribute("educationExperience", educationExperience);
		request.setAttribute("resume_id", educationExperience.getResume_id());
		return "/WEB-INF/web/manage/resume/resumeEducationExperienceUpdateSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/education_experience/update", method = RequestMethod.POST)
	public String modifyEducationExperienceSubmit(EducationExperience educationExperience){
		resumeDao.updateEducationExperience(educationExperience);
		return "redirect:/manage/resume/update?id="+educationExperience.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/education_experience/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result educationExperienceDelete(Long id){
		resumeDao.deleteEducationExperience(id);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/resume/train/add", method = RequestMethod.GET)
	public String trainAdd(Long resume_id,HttpServletRequest request){
		request.setAttribute("opt", "增加培训经历");
		request.setAttribute("resume_id", resume_id);
		return "/WEB-INF/web/manage/resume/resumeTrainAddSurface.jsp";
	}
	
	
	@RequestMapping(value = "/manage/resume/train/add", method = RequestMethod.POST)
	public String trainAddSubmit(Train train){
		train.setId(CommonUtil.nextId());
		resumeDao.insertTrain(train);
		return "redirect:/manage/resume/update?id="+train.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/train/update", method = RequestMethod.GET)
	public String trainUpdateInput(Long id,HttpServletRequest request){
		request.setAttribute("opt", "修改培训经历");		
		Train train = resumeDao.getTrain(id);
		request.setAttribute("train", train);
		request.setAttribute("resume_id", train.getResume_id());
		return "/WEB-INF/web/manage/resume/resumeTrainUpdateSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/train/update", method = RequestMethod.POST)
	public String modifyTrainSubmit(Train train){
		resumeDao.updateTrain(train);
		return "redirect:/manage/resume/update?id="+train.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/train/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result trainDelete(Long id){
		resumeDao.deleteTrain(id);
		return Result.ok();
	}
	
	
	
	@RequestMapping(value = "/manage/resume/certificate/add", method = RequestMethod.GET)
	public String certificateAdd(Long resume_id,HttpServletRequest request){
		request.setAttribute("opt", "增加证书");
		request.setAttribute("resume_id", resume_id);
		return "/WEB-INF/web/manage/resume/resumeCertificateAddSurface.jsp";
	}
	
	
	@RequestMapping(value = "/manage/resume/certificate/add", method = RequestMethod.POST)
	public String certificateAddSubmit(Certificate certificate){
		certificate.setId(CommonUtil.nextId());
		resumeDao.insertCertificate(certificate);
		return "redirect:/manage/resume/update?id="+certificate.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/certificate/update", method = RequestMethod.GET)
	public String certificateUpdateInput(Long id,HttpServletRequest request){
		request.setAttribute("opt", "修改证书");		
		Certificate certificate = resumeDao.getCertificate(id);
		request.setAttribute("certificate", certificate);
		request.setAttribute("resume_id", certificate.getResume_id());
		return "/WEB-INF/web/manage/resume/resumeCertificateUpdateSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/certificate/update", method = RequestMethod.POST)
	public String modifyCertificateSubmit(Certificate certificate){
		resumeDao.updateCertificate(certificate);
		return "redirect:/manage/resume/update?id="+certificate.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/certificate/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result certificateDelete(Long id){
		resumeDao.deleteCertificate(id);
		return Result.ok();
	}
	
	
	@RequestMapping(value = "/manage/resume/language/add", method = RequestMethod.GET)
	public String languageAdd(Long resume_id,HttpServletRequest request){
		request.setAttribute("opt", "增加语言");
		request.setAttribute("resume_id", resume_id);
		return "/WEB-INF/web/manage/resume/resumeLanguageAddSurface.jsp";
	}
	
	
	@RequestMapping(value = "/manage/resume/language/add", method = RequestMethod.POST)
	public String languageAddSubmit(Language language){
		language.setId(CommonUtil.nextId());
		resumeDao.insertLanguage(language);
		return "redirect:/manage/resume/update?id="+language.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/language/update", method = RequestMethod.GET)
	public String languageUpdateInput(Long id,HttpServletRequest request){
		request.setAttribute("opt", "修改语言");		
		Language language = resumeDao.getLanguage(id);
		request.setAttribute("language", language);
		request.setAttribute("resume_id", language.getResume_id());
		return "/WEB-INF/web/manage/resume/resumeLanguageUpdateSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/language/update", method = RequestMethod.POST)
	public String modifyLanguageSubmit(Language language){
		resumeDao.updateLanguage(language);
		return "redirect:/manage/resume/update?id="+language.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/language/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result languageDelete(Long id){
		resumeDao.deleteLanguage(id);
		return Result.ok();
	}
	
	
	@RequestMapping(value = "/manage/resume/expand/add", method = RequestMethod.GET)
	public String expandAdd(Long resume_id,HttpServletRequest request){
		request.setAttribute("opt", "增加自定义说明");
		request.setAttribute("resume_id", resume_id);
		return "/WEB-INF/web/manage/resume/resumeExpandAddSurface.jsp";
	}
	
	
	@RequestMapping(value = "/manage/resume/expand/add", method = RequestMethod.POST)
	public String expandAddSubmit(Expand expand){
		expand.setId(CommonUtil.nextId());
		resumeDao.insertExpand(expand);
		return "redirect:/manage/resume/update?id="+expand.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/expand/update", method = RequestMethod.GET)
	public String expandUpdateInput(Long id,HttpServletRequest request){
		request.setAttribute("opt", "修改自定义说明");		
		Expand expand = resumeDao.getExpand(id);
		request.setAttribute("expand", expand);
		request.setAttribute("resume_id", expand.getResume_id());
		return "/WEB-INF/web/manage/resume/resumeExpandUpdateSurface.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/expand/update", method = RequestMethod.POST)
	public String modifyExpandSubmit(Expand expand){
		resumeDao.updateExpand(expand);
		return "redirect:/manage/resume/update?id="+expand.getResume_id();
	}
	
	@RequestMapping(value = "/manage/resume/expand/delete", method = RequestMethod.POST)
	@ResponseBody
	public Result expandDelete(Long id){
		resumeDao.deleteExpand(id);
		return Result.ok();
	}
	
	@RequestMapping(value = "/manage/resume/apply-record", method = RequestMethod.GET)
	public String applyRecord(HttpServletRequest request,@RequestParam(required=false,defaultValue="1") Integer page){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		List<JobApply> jobApplyList = resumeService.userJobApplyRecord(page, user.getId());
		request.setAttribute("jobApplyList", jobApplyList);
		return "/WEB-INF/web/manage/resume/applyRecordList.jsp";
	}
	
	@RequestMapping(value = "/manage/resume/received-interview", method = RequestMethod.GET)
	public String receivedInterview(HttpServletRequest request,@RequestParam(required=false,defaultValue="1") Integer page){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		List<Interview> interviewList = resumeService.receiveInterviewList(page, user.getId());
		request.setAttribute("interviewList", interviewList);
		return "/WEB-INF/web/manage/resume/receivedInterviewList.jsp";
	}
	
	@RequestMapping(value = "/manage/interview/{id}", method = RequestMethod.GET)
	public String showInterview(HttpServletRequest request,@PathVariable Long id){
		User user = ViewHelper.getInstance().getWebTokenUser(request);
		Interview interview = resumeService.getInterview(id);
		request.setAttribute("interview", interview);
		return "/WEB-INF/web/manage/resume/interview.show.jsp";
	}
	

}
