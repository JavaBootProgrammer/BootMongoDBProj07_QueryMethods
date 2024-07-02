package com.headfirst.service;

import com.headfirst.entity.Book;
import com.headfirst.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Optional;

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
	public  List<Book>  findBooksByPagesGreaterThanEqualService(Integer pageNumber) {
		System.out.println("-------"+"findBooksByPagesGreaterThanEqualService"+"-------"+bookRepository.findBooksByPagesGreaterThanEqual(pageNumber));

		Integer list = bookRepository.findBooksByPagesGreaterThanEqual(pageNumber).size();
		System.out.println("size of list is : "+list);

		for (Book obj:  bookRepository.findBooksByPagesGreaterThanEqual(pageNumber)){

			System.out.println("---------------------");
			System.out.println("each item in the list : "+obj);


			System.out.println("Book Author is : "+ obj.getAuthor());
			System.out.println("Id is are : "+ obj.getId());
			System.out.println("Title is : "+ obj.getTitle());
			System.out.println("Total Pages are : "+ obj.getPages());
			System.out.println("---------------------");
		}


		return bookRepository.findBooksByPagesGreaterThanEqual(pageNumber);
	}

}

