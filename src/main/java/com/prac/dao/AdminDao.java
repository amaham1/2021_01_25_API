package com.prac.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prac.model.AdminModel;

@Repository("AdminDao")
public class AdminDao {
	
		@Autowired
	    JdbcTemplate jdbcTemplate;
		
		public boolean checkPassword(Map<String, Object> param) throws Exception {
			return true;
		}
		
		public AdminModel getAdminInfo(Map<String, Object> param) throws Exception {
			return (AdminModel) jdbcTemplate.queryForList("getAdminInfo", param);
		}
 }
