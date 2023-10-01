package com.onlinebookstore.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Customer;
import com.onlinebookstore.service.BookService;

import lombok.Data;

@Controller
public class BookController {
	@Autowired  
	private BookService bookService;
	
	@PostMapping("/save_book")
	public String saveBook(@ModelAttribute("book") Book book) throws Exception {
		bookService.saveBook(book);
		return "redirect:/books";
	}

	@GetMapping("/show_new_book_form")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Book book = new Book();
		model.addAttribute("book", book);
		return "new_book";
	}
//	/*@PostMapping("/saveEmployee")
//	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//		// save employee to database
//		employeeService.saveEmployee(employee);
//		return "redirect:/";
//	}*/

	@GetMapping("/books")
	public String viewHomePage(Model model) {
		return findPaginated(1, "bookName", "asc", model);
	}
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) {
		int pageSize = 5;
		Page<Book> page= bookService.getAllBooks(pageNo,pageSize, sortField, sortDir);
		List<Book> booksList= page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("bookslist", booksList);
		return "products";
	}
}