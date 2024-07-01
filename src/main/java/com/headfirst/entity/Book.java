package com.headfirst.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@Document(collection = "book")
public class Book {

	@Id
	private String id;

	private String author;

	private Integer pages;

	private String title;

	@Override
	public String toString() {
		return "Book{" +
				"id='" + id + '\'' +
				", author='" + author + '\'' +
				", pages=" + pages +
				", press='" + title + '\'' +
				'}';
	}



}
