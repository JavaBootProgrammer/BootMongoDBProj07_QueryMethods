package com.headfirst.runner;

import com.headfirst.entity.Book;
import com.headfirst.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MongoRepoRunner implements CommandLineRunner {

	@Autowired
	BookServiceImpl bookService;


	@Override
	public void run(String... args) throws Exception {


		System.out.println("-------");
		findBooksByPagesGreaterThanEqualService();
		System.out.println("-------");

	}

	private void findByID(String yand) {

		System.out.println("-------------------");
		System.out.println(bookService.findByAuthorService(yand));
		System.out.println("-------------------");
	}


	private void findAllBooks() {
		System.out.println("***************");
		bookService.findAllBooksService().forEach(System.out::println);
		System.out.println("***************");
	}
	private void findBooksByPagesGreaterThanEqualService() {
		System.out.println("***************");
		System.out.println(bookService.findBooksByPagesGreaterThanEqualService(200));
		System.out.println("***************");
	}
}







