package com.example.demo.exceptionfamily;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(BrandServiceException.class)
	public ResponseEntity<String> brandServiceException (BrandServiceException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> validproduct(MethodArgumentNotValidException e) {
		return new ResponseEntity<>("invalid data empty fields", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BrandChannelException.class)
	public ResponseEntity<List<String>> validproduct(BrandChannelException e) {
		
		return new ResponseEntity<List<String>>(e.getErrorMessages(), HttpStatus.UNPROCESSABLE_ENTITY);
	}



	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundException(ProductNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}


	}
