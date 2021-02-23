package com.prac.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.model.GoodsModel;

@Repository("GoodsDao")
public class GoodsDao {
	private static final Logger logger = LoggerFactory.getLogger(GoodsDao.class);

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int postGoods(GoodsModel goodsModel) throws Exception{
		logger.info("GoodsDao - postGoods 실행됨");
		return sqlSessionTemplate.insert("postGoods", goodsModel);
	}

	public List<GoodsModel> getGoodsList(Map<String, Object> param) throws Exception {
		logger.info("GoodsDao - getGoodsList 실행됨");
		return sqlSessionTemplate.selectList("getGoodsList", param);
	}

	public int getGoodsListCnt(Map<String, Object> param) throws Exception {
		logger.info("GoodsDao - getGoodsListCnt 실행됨");
		return (int)sqlSessionTemplate.selectOne("getGoodsListCnt", param);
	}
	
	public GoodsModel getGoodsListDetail(Map<String, Object> param) throws Exception {
		logger.info("GoodsDao - getGoodsDeatil 실행됨");
		return (GoodsModel)sqlSessionTemplate.selectOne("getGoodsDeatil", param);
	}
}
