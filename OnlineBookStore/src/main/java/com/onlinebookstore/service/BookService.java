package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.entity.Book;
import org.springframework.data.domain.Page;

public interface BookService {
	Book saveBook(Book book);
	 Page<Book> getAllBooks(int pageNo, int pageSize, String sortField, String sortDirection);
}
