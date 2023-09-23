package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.entity.Book;

public interface BookService {
	Book saveBook(Book book);
	List<Book> getAllBooks();
}
