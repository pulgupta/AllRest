package com.spring.mapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.mapper.entity.InputRequestEntity;

/**
 * This controller will get a xml rest request from the client
 * Then it will do the mapping between the input and the client entity
 * Finally it will call the client to passing the client entity and 
 * will send the response
 * @author pulgupta
 *
 */
@RestController
public class AdapterController {
	
	//This is the user class which actually belongs to a different service 
	//However we are using it and it is perfectly working fine.
	class User {
		String username;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
		
	}
	@RequestMapping(value = "/integrate", method=RequestMethod.POST ,consumes="application/xml", produces="application/json")
	public ResponseEntity<HttpStatus> integrate(@RequestBody InputRequestEntity e) {
		System.out.println("Controller called " + e);
		User ce = new User();
		//SOME RANDOM MAPPING
		ce.setUsername(e.getName());
		
		
		System.out.println("Calling client");
		//Calling the rest service to be used as JSON
		RestTemplate rt = new RestTemplate();
		ResponseEntity<HttpStatus> responseEntity = rt.postForEntity("http://localhost:8080/user", ce, HttpStatus.class);
		return responseEntity;
	}

}
