package com.prac.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac.error.CustomException;
import com.prac.error.ErrorTypeEnum;
import com.prac.model.UserModel;
import com.prac.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public Map<String, Object> login( @RequestBody UserModel userModel) throws Exception {
		logger.info("/user/login 실행됨 " + userModel.getUser_id());
		
		String user_id = userModel.getUser_id();
		String user_pwd = userModel.getUser_pwd();
		if (user_id == null)
		{	throw new CustomException(ErrorTypeEnum.missing_parameter);	} 
		else if (user_pwd == null)
		{	throw new CustomException(ErrorTypeEnum.missing_parameter);	}
		
		return userService.userLogin(userModel);
	}


}