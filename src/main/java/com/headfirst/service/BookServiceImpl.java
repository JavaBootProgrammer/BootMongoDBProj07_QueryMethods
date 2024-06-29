package com.headfirst.service;

import com.headfirst.entity.Book;
import com.headfirst.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dockService")
public class BookServiceImpl implements BookServiceRegister {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void publishTheBook(Book newBook) {

		String dockID = bookRepository.insert(newBook).getId();

		System.out.println(dockID + " document ID");


	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();

	}

	@Override
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthorBOrderByAuthor(author);
	}

	@Override
	public List<Book> findByAuthors(Integer author1, Integer author2) {
		List<Book> list=bookRepository.findByAuthorOrderByORAuthor(author1,author2);
		return list;
	}
}
