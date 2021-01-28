package com.prac.error;

import org.springframework.http.HttpStatus;


public enum ErrorTypeEnum {

	id_is_invalid(1001, "계정이 존재하지 않습니다."),
	
	missing_parameter(2001, "필수 파라미터가 누락되었습니다.");

	public int errorCode;
	public String message;
	public HttpStatus httpStatus;

	ErrorTypeEnum(int errorCode, String message, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	ErrorTypeEnum(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
		this.httpStatus = HttpStatus.OK;
	}
}
