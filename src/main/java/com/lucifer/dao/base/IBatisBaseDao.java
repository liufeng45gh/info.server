package com.lucifer.dao.base;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;




public class IBatisBaseDao {
	
	//config
	@Autowired
	protected SqlSession sqlSession;
	
	
	
	
	
}
