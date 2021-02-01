package com.prac.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminModel {
	
	private String admin_id,
						admin_pwd,
						admin_name,
						create_dt;
}
