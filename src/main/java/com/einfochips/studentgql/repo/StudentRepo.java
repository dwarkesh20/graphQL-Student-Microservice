package com.einfochips.studentgql.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einfochips.studentgql.entity.Student;

public interface StudentRepo extends MongoRepository<Student, String>{

}
