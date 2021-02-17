package com.prac.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.google.common.collect.Maps;
import com.prac.model.BaseModel;
import com.prac.model.PageModel;


@Configuration
public class BaseController {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private Environment environment;

	protected String getMessage(String key){
		return environment.getProperty(key);
	}

	protected BaseModel ok(BaseModel model) {
		model.setResultCode(0);
		model.setDescription("호출성공");
		return model;
	}

	protected BaseModel pageOk(BaseModel model, PageModel pageModel) {
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("page", pageModel.getPage());
		map.put("total", pageModel.getTotal());
		map.put("count", pageModel.getCount());

		model.setPage(map);
		return ok(model);
	}

	protected BaseModel pageOk(BaseModel model, PageModel pageModel, Map<String, Object> map) {
		map.put("page", pageModel.getPage());
		map.put("total", pageModel.getTotal());
		map.put("count", pageModel.getCount());

		model.setPage(map);
		return ok(model);
	}

}
