package com.spring.rest.consumer;

import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.common.entity.Address;
import com.common.entity.FamilyDetails;
import com.common.entity.Student;

/**
 * Consuming rest service
 * Just like JDBC template hides all the complexity of connecting to JDBC
 * Rest template hides all the complexity like checked exceptions etc for connecting and calling a REST service.
 * 
 * In this also we will use the response entity and can get the headers, return http codes 
 * can get the body as well which will give us the object which we have highlighed in the get for entiry
 * @author pulgupta
 *
 */
public class ConsumeRest {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch(choice) {
		case 1:
			String name = "Pulkit1";
			RestTemplate rt = new RestTemplate();
			//Best way of doing and passing variables in path
			ResponseEntity<Student> responseEntity = rt.getForEntity("http://localhost:8080/AllRest/student/{name}", Student.class, name);
			if(responseEntity.getStatusCode() == HttpStatus.OK)
				System.out.println(responseEntity.getBody());
			break;
		case 2:
			postClient();
			break;
		default :
			System.out.println("Error!!");
				
		}
		in.close();
		
	}
	
	public static void postClient() {
		Address ad = new Address("21", "Wahh Society", "Water Tank", "fantasyTown");
		Address ad1 = new Address("21", "Wahh Society", "Water Tank", "fantasyTown");
		FamilyDetails fd = new FamilyDetails("Tom", "Suzi");
		Student st = new Student();
		st.setName("Jack");
		st.setClassName("Upper KG");
		st.setHouseAddress(ad);
		st.setMailingAddress(ad1);
		st.setFamilyDetails(fd);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<HttpStatus> responseEntity = rt.postForEntity("http://localhost:8080/AllRest/student/", st, HttpStatus.class);
		System.out.println(responseEntity.getStatusCode());
	}
}
