package com.onlinebookstore.controller;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Cart;
import com.onlinebookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public String addToCart(@ModelAttribute("book") Book book){
        cartService.addBookToCart(book);
        return "redirect:/books";
    }
}
