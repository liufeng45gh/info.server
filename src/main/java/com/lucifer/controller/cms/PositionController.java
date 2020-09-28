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

import com.lucifer.dao.PositionDao;
import com.lucifer.model.Position;
import com.lucifer.service.PositionService;
import com.lucifer.util.RandomUtil;

@Controller
public class PositionController {
	
	@Resource
	private PositionDao positionDao;
	
	@Resource
	private PositionService positionService;
	
	private static  Log log = LogFactory.getLog(PositionController.class);
	
	@RequestMapping(value="/cms/self/position",method = RequestMethod.GET)
	public String list(HttpServletRequest request){
		List<Position> positionList=positionDao.positionList();
		request.setAttribute("positionList", positionList);
		return "/WEB-INF/cms/self/position.jsp";
	}
	
	@RequestMapping(value="/cms/self/position/add",method = RequestMethod.GET)
	public String positionAddInput(String parent_id,HttpServletRequest request){
		List<Position> positionList=positionDao.positionList();
		request.setAttribute("positionList", positionList);
		Position parnetPosition = null;
		if("0".equals(parent_id)){
			parnetPosition=new Position();
			parnetPosition.setId("0");
			parnetPosition.setName("根节点");
		}else{
			parnetPosition=positionDao.getPosition(parent_id);
		}
		
		request.setAttribute("parnetPosition", parnetPosition);
		return "/WEB-INF/cms/self/positionAdd.jsp";
	}
	@RequestMapping(value="/cms/self/position/add",method = RequestMethod.POST)
	public String positionAddSubmit(Position position){
		//log.info(city);
		//log.info(city.getId());
		position.setId(RandomUtil.getNextCityId(position.getParent_id()));
		positionDao.insert(position);
		return "redirect:/cms/self/position";
	}
	
	@RequestMapping(value="/cms/self/position/update",method = RequestMethod.GET)
	public String positionUpdateInput(String id,HttpServletRequest request){
		list(request);
		Position position=positionDao.getPosition(id);
		Position childIndustry = positionDao.getOneChild(position.getId());
		if (null != childIndustry) {
			position.setTerminal(false);
		} else {
			position.setTerminal(true);
		}
		Position parnetPosition=null;
		if (position.getParent_id().equals("0")) {
			parnetPosition=new Position();
			parnetPosition.setId("0");
			parnetPosition.setName("根节点");
		} else {
			parnetPosition = positionDao.getPosition(position.getParent_id());
		}
		request.setAttribute("parnetPosition", parnetPosition);		
				
		request.setAttribute("position", position);
		return "/WEB-INF/cms/self/positionUpdate.jsp";
	}
	
	@RequestMapping(value="/cms/self/position/update",method = RequestMethod.POST)
	public String industryUpdateSubmit(Position position){
		positionDao.updateIndustry(position);
		return "redirect:/cms/self/position";
	}
	
	@RequestMapping(value="/cms/self/position/delete",method = RequestMethod.POST)
	public String industryDelete(String id){
		positionDao.delete(id);
		return "redirect:/cms/self/position";
	}
	
	@RequestMapping(value="/cms/self/position/exist",method = RequestMethod.GET)
	@ResponseBody
	public Map isPositionExist(String id){
		Map resultMap =new HashMap();
		Position position = positionDao.getPosition(id);
		if(null==position){
			resultMap.put("is_exist", false);
		}else{
			resultMap.put("is_exist", true);
		}
		return resultMap;
	}
	
	@RequestMapping(value="/cms/self/position/alldata.json",method = RequestMethod.GET)
	@ResponseBody
	public List json(){
		List<Position> positionList=positionDao.positionList();
		return positionService.toCombotreeData(positionList);
	}

}
