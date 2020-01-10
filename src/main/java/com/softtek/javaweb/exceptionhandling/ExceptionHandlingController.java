package com.softtek.javaweb.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sofftek.javaweb.exceiption.UserAlreadyExistsException;
import com.softtek.javaweb.domain.model.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse handleAddException(UserAlreadyExistsException e) {
		return e.getErrorResponse();
	}
}
