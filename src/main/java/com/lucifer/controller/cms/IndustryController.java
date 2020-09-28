package com.lucifer.controller.cms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucifer.dao.IndustryDao;
import com.lucifer.model.Industry;
import com.lucifer.service.IndustryService;
import com.lucifer.util.RandomUtil;

@Controller
public class IndustryController {
	
	@Resource
	private IndustryDao industryDao;
	
	@Resource
	private IndustryService industryService;
	
	private static  Log log = LogFactory.getLog(IndustryController.class);
	
	@RequestMapping(value="/cms/self/industry",method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		List<Industry> industryList=industryDao.industryList();
		request.setAttribute("industryList", industryList);
		return "/WEB-INF/cms/self/industry.jsp";
	}
	
	@RequestMapping(value="/cms/self/industry/add",method = RequestMethod.GET)
	public String cityAddInput(String parent_id,HttpServletRequest request){
		List<Industry> industryList=industryDao.industryList();
		request.setAttribute("industryList", industryList);
		Industry parnetIndustry = null;
		if("0".equals(parent_id)){
			parnetIndustry=new Industry();
			parnetIndustry.setId("0");
			parnetIndustry.setName("根节点");
		}else{
			parnetIndustry=industryDao.getIndustry(parent_id);
		}
		
		request.setAttribute("parnetIndustry", parnetIndustry);
		return "/WEB-INF/cms/self/industryAdd.jsp";
	}
	@RequestMapping(value="/cms/self/industry/add",method = RequestMethod.POST)
	public String industryAddSubmit(Industry industry){
		//log.info(city);
		//log.info(city.getId());
		industry.setId(RandomUtil.getNextCityId(industry.getParent_id()));
		industryDao.insert(industry);
		return "redirect:/cms/self/industry";
	}
	
	@RequestMapping(value="/cms/self/industry/update",method = RequestMethod.GET)
	public String industryUpdateInput(String id,HttpServletRequest request){
		list(request);
		Industry industry=industryDao.getIndustry(id);
		Industry childIndustry=industryDao.getOneChild(industry.getId());
		if(null!=childIndustry){
			industry.setTerminal(false);
		}else{
			industry.setTerminal(true);
		}
		Industry parnetIndustry=null;
		if(industry.getParent_id().equals("0")){
			parnetIndustry=new Industry();
			parnetIndustry.setId("0");
			parnetIndustry.setName("根节点");
		}else{
			parnetIndustry=industryDao.getIndustry(industry.getParent_id());
		}
		request.setAttribute("parnetIndustry", parnetIndustry);		
				
		request.setAttribute("industry", industry);
		return "/WEB-INF/cms/self/industryUpdate.jsp";
	}
	
	@RequestMapping(value="/cms/self/industry/update",method = RequestMethod.POST)
	public String industryUpdateSubmit(Industry industry){
		industryDao.updateIndustry(industry);
		return "redirect:/cms/self/industry";
	}
	
	@RequestMapping(value="/cms/self/industry/delete",method = RequestMethod.POST)
	public String industryDelete(String id){
		industryDao.delete(id);
		return "redirect:/cms/self/industry";
	}
	
	@RequestMapping(value="/cms/self/industry/exist",method = RequestMethod.GET)
	@ResponseBody
	public Map isCityExist(String id){
		Map resultMap =new HashMap();
		Industry city=industryDao.getIndustry(id);
		if(null==city){
			resultMap.put("is_exist", false);
		}else{
			resultMap.put("is_exist", true);
		}
		return resultMap;
	}
	
	@RequestMapping(value="/cms/self/industry/alldata.json",method = RequestMethod.GET)
	@ResponseBody
	public List json(){
		List<Industry> industryList=industryDao.industryList();
		return industryService.toCombotreeData(industryList);
	}

}
