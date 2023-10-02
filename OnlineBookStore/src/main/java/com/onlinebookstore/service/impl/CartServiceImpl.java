package com.onlinebookstore.service.impl;

import com.onlinebookstore.entity.*;
import com.onlinebookstore.repo.BookRepo;
import com.onlinebookstore.repo.CartRepo;
import com.onlinebookstore.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class CartServiceImpl implements CartService {

    @Bean
    public ModelMapper modelMapper1() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private BookRepo bookRepo;

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

    @Override
    public Page<Cart> getAllItems(int pageNo, int pageSize, String sortField, String sortDirection){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        Sort sort= sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();
        Pageable pageable= PageRequest.of(pageNo -1, pageSize,sort);
                Page<Cart> cart= cartRepo.findByUsername(currentUser,pageable);
        return cart;
    }



    public Cart addBookToCart(String bookId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        Book book=bookRepo.getById(bookId);
        Cart cart = null;
        Cart c= bookToCart(book);
        c.setUser(currentUser);
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
