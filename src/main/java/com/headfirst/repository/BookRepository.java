package com.headfirst.repository;

import com.headfirst.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query(value = "{author: ?0}")
  public    List<Book> findByAuthorBOrderByAuthor(String author);


    @Query("{pages: {$in: [authorOne, authorTwo]}}")
    public    List<Book> findByAuthorOrderByORAuthor(Integer authorOne,Integer authorTwo);
}
