package com.onlinebookstore.service;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Cart;
import org.springframework.data.domain.Page;

public interface CartService {
    Cart addBookToCart(Book book);
    public Cart addBookToCart(String bookId);
     Page<Cart> getAllItems(int pageNo, int pageSize, String sortField, String sortDirection);
}
