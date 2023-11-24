package com.einfochips.studentgql.dto;

import lombok.Data;

@Data
public class Book {
	private String id;	
	private String title;
	private String desc;
	private String author;
	private double price;
	private int pages;
}
