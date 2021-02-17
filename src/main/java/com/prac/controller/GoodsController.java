package com.prac.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac.model.BaseModel;
import com.prac.model.BodyModel;
import com.prac.model.GoodsModel;
import com.prac.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	GoodsService goodsService;
	
	@PostMapping("/postgoods") 
	public BaseModel postGoods(@RequestBody GoodsModel goodsModel) throws Exception
	{ 	logger.info("/goods/postgoods 실행됨 ");
		BodyModel body = new BodyModel();
	
		body.setBody(goodsService.postGoods(goodsModel) == 1 ? "insert succcess" : "error");
		return ok(body);
	}
	
	@GetMapping("/getgoodslist")
	public BaseModel getGoosList(GoodsModel goodsModel) throws Exception
	{	logger.info("/goods/getgoodslist 실행됨 " + goodsModel.getFarm_name());
		BodyModel body = new BodyModel();

		List<GoodsModel> goodsList = goodsService.getGoodsList(goodsModel);
		
		body.setBody(goodsList);
		return ok(body);
	}
}
