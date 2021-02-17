package com.prac.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsModel {
	
	private String goods_name
						, goods_price
						, goods_desc
						, deliver_possible_dt
						, create_dt
						, goods_uploader;
}
