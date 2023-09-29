package com.onlinebookstore.service.impl;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Cart;
import com.onlinebookstore.entity.Customer;
import com.onlinebookstore.entity.UserDto;
import com.onlinebookstore.repo.CartRepo;
import com.onlinebookstore.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class CartServiceImpl implements CartService {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
    @Autowired
    private CartRepo cartRepo;

    @Override
    public void addToCart(Book book) {
        Cart c=bookToCart(book);
        cartRepo.save(c);
        return null;
    }


    private Cart bookToCart(Book book) {
        return modelMapper().map(book, Cart.class);
    }
}
