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
						, goods_id
						, goods_desc
						, deliver_possible_dt
						, create_dt
						, goods_uploader
						, start_goods_price
						, end_goods_price
						, start_create_dt
						, end_create_dt
						, farm_name
						, farm_phone_num
						, farm_location
						, farm_photo
						;
}
