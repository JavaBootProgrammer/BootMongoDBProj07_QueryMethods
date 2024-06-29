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
	BookServiceImpl bookWriterImpl;


	@Override
	public void run(String... args) throws Exception {

		//System.out.println(bookWriterImpl.findByAuthor("RGV"));
		System.out.println("-------");
		System.out.println(bookWriterImpl.findByAuthors(401,420));
		System.out.println("-------");

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

	}

	private void findAllBooks() {
		System.out.println("***************");
		bookWriterImpl.findAllBooks().forEach(System.out::println);
		System.out.println("***************");
	}



}
