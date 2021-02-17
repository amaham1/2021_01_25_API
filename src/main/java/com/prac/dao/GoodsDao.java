package com.prac.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prac.model.GoodsModel;

@Repository("GoodsDao")
public class GoodsDao {

		@Autowired
		SqlSessionTemplate sqlSessionTemplate;
		public List<GoodsModel> getGoodsList(Map<String, Object> param) throws Exception {
			return sqlSessionTemplate.selectList("getGoodsList", param);
		}
}
