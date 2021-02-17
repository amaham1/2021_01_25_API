package com.prac.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.dao.PostDao;
import com.prac.model.PostModel;

@Service("PostService")
public class PostService {
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	
	@Autowired
	PostDao postDao;
	
	public void setPoster(PostModel postModel) throws Exception {
		logger.info("PostService - setPost 실행됨");
		
		Map<String, Object> param = Map.of(
				"board_title", postModel.getBoard_title()
				, "board_content", postModel.getBoard_content()
		);
		postDao.setPoster(param);
	}
	
	public List<PostModel> getPoster(Map<String, Object> param) throws Exception {
		return postDao.getPoster(param);
	}
}
