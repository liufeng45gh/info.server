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

import com.lucifer.dao.PositionDao;
import com.lucifer.model.Position;
import com.lucifer.util.StringUtil;
import com.lucifer.util.WxPinYinHelper;

@Service
public class PositionService {

	private static  Log log = LogFactory.getLog(PositionService.class);
	@Resource
	private PositionDao positionDao;
	public List<String> refPositionNameList(String name) throws BadHanyuPinyinOutputFormatCombination{
		List<String> positionNameList=new ArrayList<String>();
		if(StringUtil.isEmpty(name)){
			return positionNameList;
		}
		String name_py=WxPinYinHelper.getHanYuPinYin(name);
		Position position = new Position();
		position.setName(name);
		List<Position> db_positionList= positionDao.refList(position);		
		for(Position db_position :db_positionList){
			if(positionNameList.contains(db_position.getName())){
				continue;
			}
			positionNameList.add(db_position.getName());
		}
		return positionNameList;
	}
	
	public List toCombotreeData(List<Position> positionList ){
		Map<String,Position> tempMap = new HashMap<String,Position>();
		for(Position position:positionList){
			tempMap.put(position.getId(), position);
		}
		List<Position> resultList = new ArrayList<Position>();
		for(Position position:positionList){
			if(position.getId().length()>4){
				Position parent = tempMap.get(position.getId().substring(0, position.getId().length()-4));
				parent.children.add(position);
			}else{
				resultList.add(position);
			}
		}
		return resultList;
		
	}
	
	private List<Position> positionTopList;
	
	public List<Position> getPositionTopList() {
		return positionTopList;
	}

	@PostConstruct
	public void init(){
		positionTopList = positionDao.getPositionTopList();
		for(Position position:positionTopList){
			position.children = positionDao.getPositionChildList(position.getId());
		}
	}
	

}
