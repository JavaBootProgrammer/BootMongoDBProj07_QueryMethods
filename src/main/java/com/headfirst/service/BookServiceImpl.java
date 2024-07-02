package com.headfirst.service;

import com.headfirst.entity.Book;
import com.headfirst.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dockService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void publishTheBookService(Book newBook) {

		String dockID = bookRepository.insert(newBook).getId();

		System.out.println(dockID + " document ID");


	}

	@Override
	public List<Book> findAllBooksService() {
		return bookRepository.findAll();

	}

	@Override
	public List<Book> findByAuthorService(String author) {
		return bookRepository.findByAuthorBOrderByAuthor(author);
	}

	@Override
	public List<Book> findBookByPagesService(Integer author1) {
		Query query = new Query();
		query.addCriteria(Criteria.where("pages").is("401"));
//		List<Book> users = mongoTemplate.find(query, User.class);
        return bookRepository.findBookByPages(author1);
	}

	@Override
	public List<Book> findBooksByPagesGreaterThanEqualService(Integer pageNumber) {
		System.out.println("-------"+"findBooksByPagesGreaterThanEqualService"+"-------");
		return bookRepository.findBooksByPagesGreaterThanEqual(pageNumber);
	}

}

