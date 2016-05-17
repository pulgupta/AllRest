package com.spring.rest.consumer;

import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
 * can get the body as well which will give us the object which we have highlighted in the get for entiry
 * @author pulgupta
 *
 */
public class ConsumeRest {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch(choice) {
		case 1:
			String name = "Jhon";
			RestTemplate rt = new RestTemplate();
			//Best way of doing and passing variables in path
			ResponseEntity<Student> responseEntity = rt.getForEntity("http://localhost:8080/AllRest/student/{name}", Student.class, name);
			Student st = responseEntity.getBody();
			
			if(responseEntity.getStatusCode() == HttpStatus.OK)
				System.out.println(responseEntity.getBody());
			break;
		case 2:
			postClient();
			break;
		case 3:
			postClientWithHeaders();
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
		System.out.println(responseEntity.getHeaders().getLocation());
	}
	
	public static void postClientWithHeaders() {
		Address ad = new Address("21", "Wahh Society", "Water Tank", "fantasyTown");
		Address ad1 = new Address("21", "Wahh Society", "Water Tank", "fantasyTown");
		FamilyDetails fd = new FamilyDetails("Tom", "Suzi");
		Student st = new Student();
		st.setName("Jhon");
		st.setClassName("Upper KG");
		st.setHouseAddress(ad);
		st.setMailingAddress(ad1);
		st.setFamilyDetails(fd);
		RestTemplate rt = new RestTemplate();
		//Till now the above method and this method is same
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Accept", "application/json");
		//First parameter will be the object to pass and the second will be the headers
		HttpEntity<Object> requestEntity = new HttpEntity<>(st,headers);
		ResponseEntity<HttpStatus> responseEntity = rt.exchange("http://localhost:8080/AllRest/student/",
				HttpMethod.POST, requestEntity, HttpStatus.class);
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getHeaders().getLocation());
	}
}
