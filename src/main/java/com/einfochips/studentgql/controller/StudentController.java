package com.einfochips.studentgql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.einfochips.studentgql.dto.StudentDto;
import com.einfochips.studentgql.entity.Student;
import com.einfochips.studentgql.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@MutationMapping("addStudent")
	public Student addStudent(@Argument Student student) {
		return service.addStudent(student);
	}
	
	@QueryMapping("allStudents")
	public List<Student> getStudents() {
		return service.getStudents();
	}
	
	@QueryMapping("getStudent")
	public StudentDto getStudent(@Argument String id) {
		return service.getStudentById(id);
	}
	
	@MutationMapping("deleteStudent")
	public Boolean deleteStudent(@Argument String id){
		return service.deleteStudent(id);
	}
}
