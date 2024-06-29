package com.headfirst.runner;

import com.headfirst.entity.Book;
import com.headfirst.repository.BookRepository;
import com.headfirst.service.BookServiceRegister;
import com.headfirst.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoRepoRunner implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookServiceRegister bookServiceRegister;

	@Autowired
	BookServiceImpl bookWriterImpl;


	@Override
	public void run(String... args) throws Exception {

//		publishABook();
//		findAllBooks();
//		findByID("667c6b5d46d4243be51bf197");
		List<Book> authors= bookRepository.findByAuthorBOrderByAuthor("RGV");
		System.out.println(authors);




	}

	private void findByID(String yand) {

		System.out.println("-------------------");
		System.out.println(bookWriterImpl.findByAuthor(yand));
		System.out.println("-------------------");
	}

	private void publishABook() {
		Book book = new Book();
		book.setAuthor("Yadamoor Veren");
		book.setPages(403);
		book.setPress("Vijayawada");
		bookServiceRegister.publishTheBook(book);
	}

	private void findAllBooks() {
		System.out.println("***************");
		bookWriterImpl.findAllBooks().forEach(System.out::println);
		System.out.println("***************");
	}



}
