package com.prac.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseModel {

	private int resultCode;
	private String description;
	private String res;
	private String resultCode2;
}
