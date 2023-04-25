package com.example.validationexample.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.validationexample.exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String,String> errorMapping = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMapping.put(error.getField(), error.getDefaultMessage());
		});
		return errorMapping;
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleUserNotFound(UserNotFoundException ex) {
		Map<String,String> errorMapping = new HashMap<>();
		errorMapping.put("ErrorMessage", ex.getMessage());
		return errorMapping;
	}
	
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	@ExceptionHandler(NoSuchElementException.class)
//	public Map<String,String> handleNotFound(NoSuchElementException ex) {
//		Map<String,String> errorMapping = new HashMap<>();
//		errorMapping.put("ErrorMessage", ex.getMessage());
//		return errorMapping;
//	}
}
