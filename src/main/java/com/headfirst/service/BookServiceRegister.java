package com.headfirst.service;

import com.headfirst.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookServiceRegister {

	public void publishTheBook(Book dock);

	public List<Book> findAllBooks();

	public Optional<Book> findByAuthor(String author);
}
