package com.einfochips.studentgql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einfochips.studentgql.dto.Book;
import com.einfochips.studentgql.dto.StudentDto;
import com.einfochips.studentgql.entity.Student;
import com.einfochips.studentgql.repo.StudentRepo;
import com.einfochips.studentgql.service.external.BookService;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private BookService bookService;
	
	public Student addStudent(Student student) {
		return repo.save(student);
	}

	public List<Student> getStudents() {
		return repo.findAll();
	}
	
	public StudentDto getStudentById(String id) {
		Student student = repo.findById(id).orElseThrow();
		
		Book book = bookService.getBook(student.getBookId());
		
		return new StudentDto(student.getId(), student.getName(), book);
	}

	public Boolean deleteStudent(String id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

}
