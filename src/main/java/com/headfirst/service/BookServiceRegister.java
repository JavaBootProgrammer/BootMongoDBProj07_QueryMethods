package com.headfirst.service;

import com.headfirst.entity.Book;

import java.util.List;

public interface BookServiceRegister {

	public void publishTheBook(Book dock);

	public List<Book> findAllBooks();

	public List<Book> findByAuthor(String author);

	public List<Book> findByAuthors(Integer author1,Integer author2);
}
