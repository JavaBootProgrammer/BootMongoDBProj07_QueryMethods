package com.headfirst.service;

import com.headfirst.entity.Book;

import java.util.List;

public interface BookService {

	public void publishTheBookService(Book dock);

	public List<Book> findAllBooksService();

	public List<Book> findByAuthorService(String author);

	public List<Book> findBookByPagesService(Integer author1);

	public List<Book> findBooksByPagesGreaterThanEqualService(Integer author1);
}
