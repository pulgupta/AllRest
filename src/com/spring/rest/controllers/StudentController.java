package com.spring.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.common.entity.Student;
import com.spring.rest.DAO.StudentDAO;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	StudentDAO studentDao = new StudentDAO();
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable String name) {
		HttpStatus status = null;
		Student student =  studentDao.getStudent(name);
		if(student == null) 
			status = HttpStatus.NOT_FOUND;
		else
			status = HttpStatus.OK;
		return new ResponseEntity<>(student, status);
		
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"application/json"})
	public void saveStudent(@RequestBody Student student) {
		studentDao.addStudent(student, student.getName());
	}

}