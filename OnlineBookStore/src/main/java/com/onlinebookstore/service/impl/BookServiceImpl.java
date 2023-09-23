package com.onlinebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.repo.BookRepo;
import com.onlinebookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;
	
	
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		Book b= null;
		Book existingBook = bookRepo.getById(book.getBookId());
		if(existingBook == null){
            return b = bookRepo.save(book);
        }else{
              new Exception("User already exist");
        }
	return null;
	}
	
	@Override
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	

}
