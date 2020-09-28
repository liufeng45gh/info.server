package com.lucifer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lucifer.dao.IndustryDao;
import com.lucifer.model.Industry;
import com.lucifer.util.StringUtil;
import com.lucifer.util.WxPinYinHelper;

@Service
public class IndustryService {

	private static  Log log = LogFactory.getLog(IndustryService.class);
	@Resource
	private IndustryDao industryDao;
	public List<String> refIndustryNameList(String name) throws BadHanyuPinyinOutputFormatCombination{
		List<String> industryNameList=new ArrayList<String>();
		if(StringUtil.isEmpty(name)){
			return industryNameList;
		}
		String name_py=WxPinYinHelper.getHanYuPinYin(name);
		Industry industry = new Industry();
		industry.setName(name);
		List<Industry> db_industryList= industryDao.refList(industry);		
		for(Industry db_industry :db_industryList){
			if(industryNameList.contains(db_industry.getName())){
				continue;
			}
			industryNameList.add(db_industry.getName());
		}
		return industryNameList;
	}
	
	public List toCombotreeData(List<Industry> industryList ){
		Map<String,Industry> tempMap = new HashMap<String,Industry>();
		for(Industry industry:industryList){
			tempMap.put(industry.getId(), industry);
		}
		List<Industry> resultList = new ArrayList<Industry>();
		for(Industry industry:industryList){
			if(industry.getId().length()>4){
				Industry parent = tempMap.get(industry.getId().substring(0, industry.getId().length()-4));
				parent.children.add(industry);
			}else{
				resultList.add(industry);
			}
		}
		return resultList;
		
	}
}
