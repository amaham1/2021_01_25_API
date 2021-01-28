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

import com.prac.error.CustomException;
import com.prac.error.ErrorTypeEnum;
import com.prac.model.AdminModel;
import com.prac.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;

	@PostMapping("/login")
	public Map<String, Object> adminLogin( @RequestBody AdminModel login ) throws Exception {
		logger.info("/login 실행됨 " + login.getAdmin_id());
		if(login.getAdmin_id() == null)
		{
			throw new CustomException(ErrorTypeEnum.missing_parameter);
		}
		return adminService.adminLogin(login);
	}
	
	@GetMapping("/info")
	public List<AdminModel> adminInfo( 
			@RequestParam(value="num") String num,
			@RequestParam(value="user_name") String user_name,
			@RequestParam(value="adminName") String adminName
			) throws Exception {
		logger.info("/info 실행됨.");
		
		Map<String, Object> param = Map.of(
				"wantColumn", "user_id",
				"wantColumn2", "type",
				"type", 3
				);
		
		List<AdminModel> adminModel = adminService.getAdminInfo(param);

		return adminModel;
	}
	
	
}
