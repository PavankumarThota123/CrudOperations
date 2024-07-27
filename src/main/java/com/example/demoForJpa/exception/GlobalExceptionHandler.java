package com.example.demoForJpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demoForJpa.response.ApiResp;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ApiResp> handleStudentNotFoundException(StudentNotFoundException ex){
		ApiResp res = new ApiResp("error", null, ex.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResp> handleGenericException(Exception ex){
		ApiResp res = new ApiResp("error", null, ex.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
}
