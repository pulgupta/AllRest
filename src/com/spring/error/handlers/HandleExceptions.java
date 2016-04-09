package com.spring.error.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptions {

	@ExceptionHandler(com.spring.error.handlers.StudentNotFoundException.class)
	public ResponseEntity<Error> studentNotFound(StudentNotFoundException e) {
		String studentId = e.getStudentId();
		Error error = new Error("Student with [" + studentId + "] not found");
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}
}
