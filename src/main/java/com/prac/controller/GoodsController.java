package com.prac.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prac.dao.GoodsDao;
import com.prac.model.BaseModel;
import com.prac.model.BodyModel;
import com.prac.model.GoodsModel;
import com.prac.model.PageModel;
import com.prac.service.GoodsService;
import com.prac.util.PagingUtils;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	GoodsDao goodsDao;
	
	@PostMapping("/postgoods") 
	public BaseModel postGoods(@RequestBody GoodsModel goodsModel) throws Exception
	{ 	logger.info("/goods/postgoods 실행됨 ");
		BodyModel body = new BodyModel();
	
		body.setBody(goodsService.postGoods(goodsModel) == 1 ? "insert succcess" : "error");
		return ok(body);
	}
	
	@GetMapping("/getgoodslist")
	public BaseModel getGoosList(GoodsModel goodsModel,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "count", required = false, defaultValue = "10") int count ) throws Exception
	{	logger.info("/goods/getgoodslist 실행됨 ");
		BodyModel body = new BodyModel();
		PageModel pageModel = PagingUtils.page(page, count);
		Map<String, Object> param = PropertyUtils.describe(pageModel);
		pageModel.setTotal(goodsDao.getGoodsListCnt(param));
		
		List<GoodsModel> goodsList = goodsService.getGoodsList(param, pageModel);
		body.setBody(goodsList);
		return pageOk(body, pageModel);
	}
}
