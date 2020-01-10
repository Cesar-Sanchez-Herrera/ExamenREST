package com.softtek.javaweb.domain.model;

import java.io.Serializable;

public class ErrorResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Integer errorCode;
	String errorMessage;
	
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessagge() {
		return errorMessage;
	}
	public void setErrorMessagge(String errorMessagge) {
		this.errorMessage = errorMessagge;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ErrorResponse (Integer errorCode, String errorMessagge) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessagge;
	}
	
	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", errorMessagge=" + errorMessage + "]";
	}
	
	
	
}
