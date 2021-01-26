package com.prac.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prac.model.AdminModel;
import com.prac.service.AdminService;
import com.google.common.collect.Maps;


@RestController
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
		
	@PostMapping("/login")
	public AdminModel adminLogin( @RequestBody AdminModel adminModel ) throws Exception {
		logger.info("/login 실행됨.");
		return adminModel;
	}
	
	@GetMapping("/info")
	public List<AdminModel> adminInfo( 
			@RequestParam(value="num") String num,
			@RequestParam(value="user_name") String user_name,
			@RequestParam(value="adminName") String adminName
			) throws Exception {
		logger.info("/info 실행됨.");
		
		Map<String, Object> param = Maps.newHashMap();
		param.put("user_name", user_name);
		
		List<AdminModel> adminModel = adminService.getAdminInfo(param);
		return adminModel;
	}
	
}
