package com.spring.rest.DAO;

import java.util.HashMap;
import java.util.Map;

import com.common.entity.Student;

public class StudentDAO {

	Map<String, Student> studentMap = null;
	
	public StudentDAO() {
		studentMap = new HashMap<String, Student>();
	}
	
	public Student getStudent(String id) {
		return studentMap.get(id);
	}
	
	public boolean addStudent(Student student, String id) {
		studentMap.put(id, student);
		return true;
	}
	
}
