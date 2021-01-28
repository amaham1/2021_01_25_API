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
	private String admin_name;
	private String create_dt;
}
