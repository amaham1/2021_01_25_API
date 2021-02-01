package com.prac.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.dao.AdminDao;
import com.prac.error.CustomException;
import com.prac.error.ErrorTypeEnum;
import com.prac.jwt.JwtUtil;
import com.prac.jwt.PasswordEncoder;
import com.prac.model.AdminModel;

@Service("AdminService")
public class AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	
		@Autowired
		AdminDao adminDao;
		
		@Autowired
		JwtUtil jwtUtil;
		
		@Autowired
		PasswordEncoder passwordEncoder;
		
		public Map<String, Object> adminLogin(AdminModel adminModel) throws Exception {
			String admin_id = adminModel.getAdmin_id();
			String first_admin_pwd = adminModel.getAdmin_pwd();
			String second_admin_pwd = adminDao.getAdminPassword(admin_id);

			//Admin 계정 유효성 체크
			boolean adminIdCheck = adminDao.checkAdminId(admin_id);
			boolean adminPwdCheck =  passwordEncoder.comparePassWord(first_admin_pwd, second_admin_pwd);
			if (adminIdCheck == false) 
			{	throw new CustomException(ErrorTypeEnum.account_is_invalid);	} 
			else if (adminPwdCheck == false)
			{	throw new CustomException(ErrorTypeEnum.account_is_invalid);	} 
			
			//토큰 생성
			String token = jwtUtil.getJwtForAdmin(admin_id);
			String type =jwtUtil.getTypeFromToken(token);			
			Map<String, Object> param = Map.of(
					"token", token,  "type", type
			);
			
			return param;
		}
		
		public List<AdminModel> getAdminInfo(Map<String, Object> param) throws Exception {
			
			List<AdminModel> adminInfo = adminDao.getAdminInfo(param);
			return adminInfo;
		}

}