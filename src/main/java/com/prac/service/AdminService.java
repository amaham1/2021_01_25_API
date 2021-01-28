package com.prac.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.dao.AdminDao;
import com.prac.error.CustomException;
import com.prac.error.ErrorTypeEnum;
import com.prac.jwt.JwtUtil;
import com.prac.model.AdminModel;

@Repository("AdminService")
public class AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	
		@Autowired
		AdminDao adminDao;
		
		@Autowired
		JwtUtil jwtUtil;
		
		public Map<String, Object> adminLogin(AdminModel adminModel) throws Exception {
			String admin_id= adminModel.getAdmin_id();
			
			//Admin 계정 체크
			boolean adminIdCheck = adminDao.checkAdminId(admin_id);
			if (adminIdCheck == false) 
			{
				throw new CustomException(ErrorTypeEnum.id_is_invalid, null);
			} 
			
			String token = jwtUtil.getJwtForAdmin(admin_id);
			String type =jwtUtil.getTypeFromToken(token);
			Map<String, Object> param = Map.of(
					"token", token
					, "type" , type
			);
			
			return param;
		}
		
		public List<AdminModel> getAdminInfo(Map<String, Object> param) throws Exception {
			List<AdminModel> adminInfo = adminDao.getAdminInfo(param);
			return adminInfo;
		}

}