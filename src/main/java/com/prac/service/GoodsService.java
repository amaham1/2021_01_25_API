package com.prac.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	public List<GoodsModel> getGoodsList(Map<String, Object> param, PageModel pageModel) throws Exception {
		logger.info("GoodsService - getGoodsList 실행됨");
		param = PropertyUtils.describe(pageModel);
		return goodsDao.getGoodsList(param);
	}
}
