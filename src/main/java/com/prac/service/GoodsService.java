package com.prac.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.dao.GoodsDao;
import com.prac.model.GoodsModel;

@Service("GoodsService")
public class GoodsService {
		
	@Autowired
	GoodsDao goodsDao;
	
	public List<GoodsModel> getGoodsList(Map<String, Object> param) throws Exception {
		return goodsDao.getGoodsList(param);
	}
}
