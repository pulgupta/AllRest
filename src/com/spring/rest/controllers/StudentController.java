package com.spring.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.common.entity.Student;
import com.spring.error.handlers.StudentNotFoundException;
import com.spring.rest.DAO.StudentDAO;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	StudentDAO studentDao = new StudentDAO();
	
	/**
	 * Points to remember : In case we just want to send an object back without using the 
	 * status codes we can specify the return type as of that object. However in case we 
	 * want to send different status code we can use 3 ways :
	 * ResponseEntity : As seen below
	 * Using @ResponseStatus annotation
	 * Using Exception handlers
	 * @param name
	 * @return
	 */
	
	/**
	 * Here we can see 2 ways of sending response codes
	 * 1. By creating separate exception handlers so as to keep happy flow and 
	 * exception flow separate
	 * 2. By doing all the error checking and Status codes determination in the happy flow itself
	 * For complex systems prefer the first one.
	 * 3. Way is somthing like this :     @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  // 404
    public class OrderNotFoundException extends RuntimeException {
        // ...
    }
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable String name) {
		Student student =  studentDao.getStudent(name);
		if(student == null) 
			throw new StudentNotFoundException(name);
		return new ResponseEntity<>(student, HttpStatus.OK);
		
	}

	/**
	 * This method shows 2 important concepts : 1. How to get the headers from the post request
	 * Also how to get the post data from the request.
	 * @param accept
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<HttpStatus> saveStudent(@RequestHeader("Accept") String accept,@RequestBody Student student) {
		HttpStatus status;
		System.out.println("Received header value is " + accept);
		boolean result = studentDao.addStudent(student, student.getName());
		status = (result) ? HttpStatus.CREATED : HttpStatus.OK;
		return new ResponseEntity<>(status);
	}
	
	/**
	 * This is working however the only issue with this approach is that it is 
	 * sending the complete stack trace to the client.
	 * @param e
	 * @return
	 *
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Error> studentNotFound(StudentNotFoundException e) {
		String studentId = e.getStudentId();
		Error error = new Error("Student with [" + studentId + "] not found");
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}*/
	
	/**
	 * This is just a modification of the above method in which we are not sending the 
	 * error object but just the String with the error message and it is showing 
	 * perfectly on the screen.
	 * @param e
	 * @return
	 */
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> studentNotFound(StudentNotFoundException e) {
		String studentId = e.getStudentId();
		String error = "Student with [" + studentId + "] not found";
		return new ResponseEntity<String>(error, HttpStatus.NOT_FOUND);
	}
	//In the above method as we know that we are always sending a single status code
	//we can annotate this method with @ResonseStatus(HttpStatus.NOT_FOUND) and can return an Error object.
	/*
	@ExceptionHandler(SpittleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error spittleNotFound(SpittleNotFoundException e) {
	  long spittleId = e.getSpittleId();
	  return new Error(4, "Spittle [" + spittleId + "] not found");
	}*/

}