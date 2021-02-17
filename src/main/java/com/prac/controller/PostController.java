package com.prac.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prac.model.BaseModel;
import com.prac.model.BodyModel;
import com.prac.model.PostModel;
import com.prac.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	PostService postService;
	
	@PostMapping("/write")
	public BaseModel post(
			@RequestHeader(value = "Authorization", required = true) String auth,
			@RequestBody PostModel postModel) throws Exception{
		logger.info("/write 실행됨 ");
		BodyModel body = new BodyModel();
		
		body.setBody(	postService.setPoster(postModel) == 1 ? "insert success": "error");
		return ok(body);
	}
	
	@GetMapping("/getposter")
	public BaseModel getPoster(
			@RequestParam(value="board_title", required = false, defaultValue = "") String board_title,
			@RequestParam(value="board_content", required = false, defaultValue = "") String board_content) throws Exception {
		logger.info("/getposter 실행됨 ");
		BodyModel body = new BodyModel();
		
		Map<String, Object> param = Map.of(
				"board_title", board_title
				, "board_content", board_content
		);
		
		List<PostModel> postModel = postService.getPoster(param);
		
		body.setBody(postModel);
		return ok(body);
	}
}
