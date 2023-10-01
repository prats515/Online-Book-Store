package com.onlinebookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		Book b= null;
		Book existingBook = bookRepo.getById(book.getBookId());
		if(existingBook == null){
            return b = bookRepo.save(book);
        }else{
              new Exception("Book already exist");
        }
	return null;
	}
	
	@Override
	public Page<Book> getAllBooks(int pageNo, int pageSize, String sortField, String sortDirection){
		Sort sort= sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
				Sort.by(sortField).descending();
		Pageable pageable= PageRequest.of(pageNo -1, pageSize, sort);
		return bookRepo.findAll(pageable);
	}
}
