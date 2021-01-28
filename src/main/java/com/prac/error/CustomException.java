package com.prac.error;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException{
	
	private static final long serialVersionUID = -7178945192162789217L;

	private ErrorTypeEnum errorType;

	public CustomException(ErrorTypeEnum type) {
		this(type, null);
	}
	
	public CustomException(ErrorTypeEnum type, String customMessage) {
		super();
		
		errorType = type;
		if (customMessage != null) {
			errorType.message = customMessage;
		}
	}

	public CustomException(ErrorTypeEnum type, String customMessage, Throwable ex) {
		super(ex);
		
		errorType = type;
		if (customMessage != null) {
			errorType.message = customMessage;
		}
	}
	
	public ErrorTypeEnum getErrorType() {
		return errorType;
	}
}
