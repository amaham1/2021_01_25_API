package com.prac.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac.model.BaseModel;
import com.prac.model.BodyModel;
import com.prac.model.GoodsModel;
import com.prac.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController{

	@Autowired
	GoodsService goodsService;
	
	@GetMapping("/getgoodslist")
	public BaseModel asd() throws Exception {
		BodyModel body = new BodyModel();
		Map<String, Object> param = Map.of();
		List<GoodsModel> goodsModel = goodsService.getGoodsList(param);
		
		body.setBody(goodsModel);
		return ok(body);
	}
	

}
