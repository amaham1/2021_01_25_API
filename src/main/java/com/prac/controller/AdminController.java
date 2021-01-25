package com.prac.controller;

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

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

		
	@PostMapping("/login")
	public AdminModel adminLogin( @RequestBody AdminModel adminModel ) throws Exception {
		logger.info("/login 실행됨.");
		return adminModel;
	}
	
	@GetMapping("/info")
	public AdminModel adminInfo( 
			@RequestParam(value="num") String num,
			@RequestParam(value="adminId") String adminId,
			@RequestParam(value="adminName") String adminName
			) throws Exception {
		
		AdminModel adminModel = adminService.getAdminInfo(param);
		return adminModel;
	}
	
}
