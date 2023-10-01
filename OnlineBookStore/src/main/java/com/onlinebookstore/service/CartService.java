package com.onlinebookstore.service;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Cart;

public interface CartService {
    Cart addBookToCart(Book book);
    public Cart addBookToCart(String bookId);
}
