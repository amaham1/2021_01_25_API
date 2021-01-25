package com.prac.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.dao.AdminDao;
import com.prac.model.AdminModel;

@Repository("AdminService")
public class AdminService {
	
		@Autowired
		AdminDao adminDao;
		
		public AdminModel adminLogin(Map<String, Object> param) throws Exception {
			AdminModel adminModel = new AdminModel();
			return adminModel;
		}
		
		public AdminModel getAdminInfo(Map<String, Object> param) throws Exception {
			AdminModel adminInfo = adminDao.getAdminInfo(param);
			return adminInfo;
		}
}