package com.prac.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.dao.UserDao;
import com.prac.error.CustomException;
import com.prac.error.ErrorTypeEnum;
import com.prac.jwt.JwtUtil;
import com.prac.jwt.PasswordEncoder;
import com.prac.model.UserModel;

@Service("UserService")
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtil jwtUtil;
	
	public Map<String, Object> userLogin(UserModel userModel) throws Exception{
		logger.info("UserService - userLogin 실행됨 " + userModel.getUser_id());
	
		String user_id = userModel.getUser_id();
		String first_user_pwd = userModel.getUser_pwd();
		String second_user_pwd = userDao.getUserPassword(user_id);
		
		//User 계정 유효성 체크
		boolean userIdCheck = userDao.checkUserId(user_id);
		boolean userPwdCheck =  passwordEncoder.comparePassWord(first_user_pwd, second_user_pwd);
		if (userIdCheck == false) 
		{	throw new CustomException(ErrorTypeEnum.account_is_invalid, null);	} 
		else if (userPwdCheck == false)
		{	throw new CustomException(ErrorTypeEnum.account_is_invalid, null);	} 
		
		//토큰 생성
		String token = jwtUtil.getJwtForAdmin(user_id);
		String type =jwtUtil.getTypeFromToken(token);
		Map<String, Object> param = Map.of(
				"token", token,  "type" , type
		);
		
		return param;
	}
	
	public List<UserModel> getUserInfo(Map<String, Object> param) throws Exception {	
		logger.info("UserService - getUserInfo 실행됨 " + param);
	
		List<UserModel> userModel = userDao.getUserInfo(param);
		return userModel;
	}

}
