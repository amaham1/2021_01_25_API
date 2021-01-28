package com.prac.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
}