package com.example.petstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
	

	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(InvalidCredentialsException invalidCredentialsException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(401);
        errorResponse.setMessage(invalidCredentialsException.getMessage());
        
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
