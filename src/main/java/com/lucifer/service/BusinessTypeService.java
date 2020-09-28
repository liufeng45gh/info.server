package com.lucifer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lucifer.dao.BusinessTypeDao;
import com.lucifer.dao.IndustryDao;
import com.lucifer.model.BusinessType;
import com.lucifer.model.Industry;
import com.lucifer.util.StringUtil;
import com.lucifer.util.WxPinYinHelper;

@Service
public class BusinessTypeService {

	private static  Log log = LogFactory.getLog(BusinessTypeService.class);
	@Resource
	private BusinessTypeDao businessTypeDao;
	public List<String> refIndustryNameList(String name) throws BadHanyuPinyinOutputFormatCombination{
		List<String> industryNameList=new ArrayList<String>();
		if(StringUtil.isEmpty(name)){
			return industryNameList;
		}
		String name_py=WxPinYinHelper.getHanYuPinYin(name);
		BusinessType industry = new BusinessType();
		industry.setName(name);
		List<BusinessType> db_industryList= businessTypeDao.refList(industry);		
		for(BusinessType db_industry :db_industryList){
			if(industryNameList.contains(db_industry.getName())){
				continue;
			}
			industryNameList.add(db_industry.getName());
		}
		return industryNameList;
	}
	
	public List toCombotreeData(List<BusinessType> industryList ){
		Map<String,BusinessType> tempMap = new HashMap<String,BusinessType>();
		for(BusinessType industry:industryList){
			tempMap.put(industry.getId(), industry);
		}
		List<BusinessType> resultList = new ArrayList<BusinessType>();
		for(BusinessType industry:industryList){
			if(industry.getId().length()>4){
				BusinessType parent = tempMap.get(industry.getId().substring(0, industry.getId().length()-4));
				parent.children.add(industry);
			}else{
				resultList.add(industry);
			}
		}
		return resultList;
		
	}
	
	private List<BusinessType> businessTypeTopList;
	
	public List<BusinessType> getBusinessTypeTopList() {
		return businessTypeTopList;
	}
	
	@PostConstruct
	public void init(){
		this.businessTypeTopList = businessTypeDao.getBusinessTypeTopList();
		for (BusinessType businessType :businessTypeTopList) {
			businessType.children = businessTypeDao.getBusinessTypeChildList(businessType.getId());
		}
	}
	
	public BusinessType getTopType(String id){
		for (BusinessType businessType:businessTypeTopList) {
//			if (businessType.getId().equals(id)) {
//				return businessType;
//			}
			if (id.startsWith(businessType.getId())) {
				return businessType;
			}
		}
		return null;
	}
	
	public BusinessType getChildType(String id){
		BusinessType topType = this.getTopType(id);
		if (topType == null) {
			return null;
		}
		for (BusinessType businessType:topType.children) {
			if (businessType.getId().equals(id)) {
				return businessType;
			}
		}
		return null;
	}
	
	
}
