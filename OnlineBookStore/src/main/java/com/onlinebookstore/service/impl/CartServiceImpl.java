package com.onlinebookstore.service.impl;

import com.onlinebookstore.entity.*;
import com.onlinebookstore.repo.CartRepo;
import com.onlinebookstore.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class CartServiceImpl implements CartService {

    @Bean
    public ModelMapper modelMapper1() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
    @Autowired
    private CartRepo cartRepo;

    @Override
    public Cart addBookToCart(Book book) {
        Cart c=bookToCart(book);
        Cart cart = null;
        Cart itemInCart = cartRepo.searchById(book.getBookId());
        if(itemInCart == null){
            return cart = cartRepo.save(c);
        }else{
            new Exception("Item already exist");
        }
        return null;
    }


    private Cart bookToCart(Book book) {
        return modelMapper1().map(book, Cart.class);
    }
}
