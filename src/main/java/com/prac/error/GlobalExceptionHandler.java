package com.prac.error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.lang.model.type.ErrorType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prac.model.BaseModel;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler({ CustomException.class })
    @ResponseBody
    public ResponseEntity<BaseModel> handleApplicationErrorException(HttpServletRequest request, CustomException e) {
		
		ErrorTypeEnum errorType = e.getErrorType();
		
		BaseModel res = new BaseModel();
		res.setResultCode(errorType.errorCode);
		res.setDescription(errorType.message);
				
        return new ResponseEntity<>(res, errorType.httpStatus);
    }	
	

	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers,HttpStatus status, WebRequest request) {
		
		BaseModel res = new BaseModel();
		res.setResultCode2("필수파라미터가 누락되었습니다");
		
        return new ResponseEntity<>(res, status);
	}
}