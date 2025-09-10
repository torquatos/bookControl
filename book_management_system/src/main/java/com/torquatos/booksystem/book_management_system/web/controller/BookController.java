package com.torquatos.booksystem.book_management_system.web.controller;

import com.torquatos.booksystem.book_management_system.entity.*;
import com.torquatos.booksystem.book_management_system.service.*;

import org.springframework.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
		}
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	
}