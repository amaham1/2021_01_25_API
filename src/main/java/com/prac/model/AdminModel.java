package com.prac.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class AdminModel {
	
	private String admin_id;
	private String admin_pwd;
	private String user_id;
	private String user_name;
	private String user_phone_num;
	private String create_dt;
}
