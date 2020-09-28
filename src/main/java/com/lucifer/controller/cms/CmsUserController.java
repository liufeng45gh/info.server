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

import com.lucifer.dao.UserDao;
import com.lucifer.model.User;
import com.lucifer.model.User;
import com.lucifer.service.UserService;
import com.lucifer.util.PageUtil;

@Controller
public class CmsUserController {

	@Resource
	private UserService userService;
	
	@Resource
	private UserDao userDao;
	
	private static  Log log = LogFactory.getLog(CmsUserController.class);
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/cms/user/list",method = RequestMethod.GET)
	public String list(Integer page,HttpServletRequest request){
		log.info("page :"+page);
		Integer perPageCount = 20;
		@SuppressWarnings("rawtypes")
		Map params=new HashMap();
		params.put(PageUtil.perPageCount, perPageCount);
		params.put(PageUtil.offset, PageUtil.getStartOffset(page, perPageCount));
		
		List<User> userList=userDao.getUserInfoList(params);
		Integer matchRecordCount=userDao.getUserInfoListCount(params);
		Integer totalPageCount=PageUtil.getTotalPageCount(matchRecordCount, perPageCount);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("userList", userList);
		return "/WEB-INF/cms/user/list.jsp";
	}
}
