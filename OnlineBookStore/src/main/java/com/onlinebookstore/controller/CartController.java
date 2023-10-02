package com.onlinebookstore.controller;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Cart;
import com.onlinebookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

   /* @PostMapping("/addToCart")
    public String addToCart(@ModelAttribute Book book){
        cartService.addBookToCart(book);
        return "redirect:/books";
    }*/

   /* @GetMapping("/addCart/{bookId}")
    public String viewPage(@PathVariable( value = "bookId") long id, Model model){

    }*/

    @GetMapping("/addToCart/{bookId}")
    public String addToCart(@PathVariable ( value = "bookId") String bookId){
        cartService.addBookToCart(bookId);
        return "redirect:/books";
    }

    @GetMapping("/cart")
    public String getCartItems(Model model){
        return findPaginated(1, "bookName", "asc", model);
    }

    @GetMapping("/pages/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
        Page<Cart> page= cartService.getAllItems(pageNo,pageSize, sortField, sortDir);
        List<Cart> cartItems= page.getContent();

        double totalAmount=cartItems.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
        int totalItems= cartItems.stream().mapToInt(item-> item.getQuantity()).sum();
        /*double totalAmount = cartItems.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalAmount", totalAmount); // Pass the totalAmount to the template
        return "cart";*/

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("totalItems",totalItems);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalAmount", totalAmount);
        return "newCart";
    }

    /* @PostMapping("/addToCart")
    public Cart addToCart( Book book){
        return  cartService.addBookToCart(book);
        //return "redirect:/books";
    }*/
}
