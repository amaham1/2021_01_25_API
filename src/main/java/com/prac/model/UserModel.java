package com.prac.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {
	
	private String user_id,
						user_pwd,
						user_name,
						user_phone_num,
						create_dt;
}
