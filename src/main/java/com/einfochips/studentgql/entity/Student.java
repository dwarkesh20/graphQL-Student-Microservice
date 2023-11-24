package com.einfochips.studentgql.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Student {
	@Id
	private String id;
	private String name;
	private String bookId;
}
