package com.prac.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.dao.AdminDao;
import com.prac.model.AdminModel;

@Repository("AdminService")
public class AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	
		@Autowired
		AdminDao adminDao;
		
		public AdminModel adminLogin(Map<String, Object> param) throws Exception {
			AdminModel adminModel = new AdminModel();
			return adminModel;
		}
		
		public List<AdminModel> getAdminInfo(Map<String, Object> param) throws Exception {
			List<AdminModel> adminInfo = adminDao.getAdminInfo(param);
			return adminInfo;
		}
}