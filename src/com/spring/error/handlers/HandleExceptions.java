package com.spring.error.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class HandleExceptions {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Error> studentNotFound(StudentNotFoundException e) {
		String studentId = e.getStudentId();
		Error error = new Error("Student with [" + studentId + "] not found");
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}
}
