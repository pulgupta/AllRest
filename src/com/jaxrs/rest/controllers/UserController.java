package com.jaxrs.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserController {
	
	class Student {
		String name;
		public void setName(String name){
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	
   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_JSON)
   public Student getUsers(){
	   Student student = new Student();
	   student.setName("Pulkit");
	   return student;
   }	
   @GET
   @Path("/usersquery")
   @Produces(MediaType.APPLICATION_JSON)
   public Student getUsers1(@QueryParam(value = "Pulkit") String studentName){
	   Student student = new Student();
	   student.setName(studentName);
	   return student;
   }
}