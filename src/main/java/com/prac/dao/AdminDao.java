package com.prac.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.prac.model.AdminModel;

@Repository("AdminDao")
public class AdminDao {
	private static final Logger logger = LoggerFactory.getLogger(AdminDao.class);
	
		@Autowired
	    SqlSessionTemplate SqlSessionTemplate;
		
		public boolean checkAdminId(String admin_id) throws Exception {
				logger.info("AdminDAO - checkAdminId 실행됨 " + admin_id);
			return (int) SqlSessionTemplate.selectOne("checkAdminId", admin_id) > 0;
		}
		
		public String getAdminPassword(String admin_pwd) throws Exception {
				logger.info("AdminDAO - getAdminPassword 실행됨 " + admin_pwd);
			return SqlSessionTemplate.selectOne("getAdminPassword", admin_pwd);
		}
		
		public List<AdminModel> getAdminInfo(Map<String, Object> param) throws Exception {
				logger.info("AdminDAO - getAdminInfo 실행됨 " + param);
			return  SqlSessionTemplate.selectList("getAdminInfo", param);
		}
 }
