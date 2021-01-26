package com.prac.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.model.AdminModel;

@Repository("AdminDao")
public class AdminDao {
	private static final Logger logger = LoggerFactory.getLogger(AdminDao.class);
	
		@Autowired
	    SqlSessionTemplate SqlSessionTemplate;
		
		public boolean checkPassword(Map<String, Object> param) throws Exception {
			return true;
		}
		
		public List<AdminModel> getAdminInfo(Map<String, Object> param) throws Exception {
			logger.info("getAdminInfo 실행됨 " + param);
			return  SqlSessionTemplate.selectList("getAdminInfo", param);
		}
 }
