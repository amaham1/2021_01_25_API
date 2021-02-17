package com.prac.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {

    private int resultCode;
    private String description;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object page;

	@Override
    public String toString() {
    	return "code : " + resultCode + ", desc : " + description;
    }
}

