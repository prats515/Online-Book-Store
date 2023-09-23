package com.onlinebookstore.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Customer;
import com.onlinebookstore.service.BookService;

import lombok.Data;

@RestController
public class BookController {
	@Autowired  
	private BookService bookService;
	
	@PostMapping("/save_book")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) throws Exception {
		Book book1= bookService.saveBook(book);
		return new ResponseEntity<>(book1, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getBooks(){
	List<Book> books=	   bookService.getAllBooks();
	return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	
}