package com.prac.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.model.UserModel;

@Repository("UserDao")
public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
    SqlSessionTemplate SqlSessionTemplate;
	
	public boolean checkUserId(String user_id) throws Exception {
			logger.info("UserDAO - checkUserId 실행됨 " + user_id);
		return (int) SqlSessionTemplate.selectOne("checkUserId", user_id) > 0;
	}
	
	public String getUserPassword(String user_pwd) throws Exception {
			logger.info("UserDAO - getUserPassword 실행됨 " + user_pwd);
		return SqlSessionTemplate.selectOne("getUserPassword", user_pwd);
	}
	
	public List<UserModel> getUserInfo(Map<String, Object> param) throws Exception {
			logger.info("UserDAO - UserDAO 실행됨 " + param);
		return  SqlSessionTemplate.selectList("UserDAO", param);
	}
}
