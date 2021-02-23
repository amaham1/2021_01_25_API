package com.prac.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.prac.dao.GoodsDao;
import com.prac.model.GoodsModel;
import com.prac.model.PageModel;

@Service("GoodsService")
public class GoodsService {
	private static final Logger logger = LoggerFactory.getLogger(GoodsService.class);
		
	@Autowired
	GoodsDao goodsDao;
	
	public int postGoods(GoodsModel goodsModel) throws Exception {
		logger.info("GoodsService - postGoods 실행됨 "+ goodsModel.getFarm_name());
		return goodsDao.postGoods(goodsModel);
	}
	
	public List<GoodsModel> getGoodsList(GoodsModel goodsModel, PageModel pageModel) throws Exception {
		logger.info("GoodsService - getGoodsList 실행됨 ");
		
		Map<String, Object> param = Maps.newHashMap();
		param.putAll(PropertyUtils.describe(goodsModel));
		param.putAll(PropertyUtils.describe(pageModel));
		
		pageModel.setTotal(goodsDao.getGoodsListCnt(param));
		return goodsDao.getGoodsList(param);
	}
	
	public GoodsModel getGoodsDetail(GoodsModel goodsModel) throws Exception {
		logger.info("GoodsService - getGoodsDetail 실행됨 ");
		
		Map<String, Object> param = Maps.newHashMap();
		param.putAll(PropertyUtils.describe(goodsModel));
		
		return goodsDao.getGoodsListDetail(param);
	}
}
