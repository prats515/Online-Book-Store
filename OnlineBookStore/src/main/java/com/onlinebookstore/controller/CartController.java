package com.onlinebookstore.controller;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Cart;
import com.onlinebookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public String addToCart(@ModelAttribute Book book){
        cartService.addBookToCart(book);
        return "redirect:/books";
    }

   /* @GetMapping("/addCart/{bookId}")
    public String viewPage(@PathVariable( value = "bookId") long id, Model model){

    }*/

    @GetMapping("/addCart/{bookId}")
    public String addToCart(@PathVariable ( value = "bookId") String bookId){
        cartService.addBookToCart(bookId);
        return "redirect:/books";
    }

    /*@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}*/

    /* @PostMapping("/addToCart")
    public Cart addToCart( Book book){
        return  cartService.addBookToCart(book);
        //return "redirect:/books";
    }*/
}
