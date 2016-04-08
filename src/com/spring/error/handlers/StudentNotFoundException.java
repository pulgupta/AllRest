package com.spring.error.handlers;

public class StudentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String studentId;
	
	public StudentNotFoundException(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentId() {
		return studentId;
	}
}
