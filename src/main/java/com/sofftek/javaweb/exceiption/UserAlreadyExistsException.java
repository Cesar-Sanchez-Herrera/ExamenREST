package com.sofftek.javaweb.exceiption;

import com.softtek.javaweb.domain.model.ErrorResponse;

public class UserAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;
	private ErrorResponse errorResponse;
	public UserAlreadyExistsException (){
		super();
	}
	
	UserAlreadyExistsException (final String message){
		super(message);
	}
	
	public UserAlreadyExistsException (final ErrorResponse error){
		super();
		this.errorResponse = error;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
