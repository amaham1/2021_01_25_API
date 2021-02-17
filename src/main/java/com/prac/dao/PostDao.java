package com.prac.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.model.PostModel;

@Repository("PostDao")
public class PostDao {
	private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
	
	@Autowired
    SqlSessionTemplate SqlSessionTemplate;
	
	public int setPoster(Map<String, Object> param) throws Exception
	{
		logger.info("PostDao - setPoster 실행됨 ");
		return SqlSessionTemplate.insert("setPoster", param);
	}
	
	public List<PostModel> getPoster(Map<String, Object> param) throws Exception
	{
		logger.info("PostDao - getPoster 실행됨 ");
		return SqlSessionTemplate.selectList("getPoster", param);
	}
	
}
