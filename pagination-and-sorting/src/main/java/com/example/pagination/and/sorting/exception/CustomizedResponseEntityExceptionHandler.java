package com.example.pagination.and.sorting.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetail> handleAllException(Exception ex, 
			WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(), ex.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity<>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<ErrorDetail> handleUserNotFoundException(Exception ex,
			WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(), ex.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String,String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
//		Map<String,String> errorMapping = new HashMap<>();
//		ex.getBindingResult().getFieldErrors().forEach(error -> {
//			errorMapping.put(error.getField(), error.getDefaultMessage());
//		});
//		return new ResponseEntity<>(errorMapping,HttpStatus.BAD_REQUEST);
//	}
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex, org.springframework.http.HttpHeaders headers, HttpStatus status,WebRequest request){
//		ErrorDetail errorDetails = new ErrorDetail(LocalDateTime.now(),ex.getFieldError().getDefaultMessage(),request.getDescription(false));
//		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
//	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, org.springframework.http.HttpHeaders headers,
			HttpStatus status,WebRequest request){		
		Map<String,String> errorMapping = new HashMap<>();
		LocalDateTime date = LocalDateTime.now();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        String output = dtf.format(date);
		errorMapping.put("timestamp", output);
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMapping.put(error.getField(), error.getDefaultMessage());
		});
		errorMapping.put("details", request.getDescription(false));
		return new ResponseEntity<>(errorMapping,HttpStatus.BAD_REQUEST);
	}
}
