package com.torquatos.booksystem.book_management_system.web.controller;

import com.torquatos.booksystem.book_management_system.entity.*;
import com.torquatos.booksystem.book_management_system.service.*;

import org.springframework.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id){
		return bookService.getBookById(id)
				.map(task -> new ResponseEntity<>(task, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book createdBook = bookService.saveBook(book);
		return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
		return bookService.getBookById(id)
				.map(existingBook -> {
					bookService.updateBook(id, book);
					return new ResponseEntity<>(book, HttpStatus.OK);				
				})
				.orElseGet(() -> new ResponseEntity<>(book, HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/{id}/status")
	public ResponseEntity<Void> updateBookStatus(@PathVariable Long id, @RequestBody Book book){
		return bookService.getBookById(id)
				.map(existingBook ->{
					bookService.updateBookStatus(id, book.getWasRead());
					return new ResponseEntity<Void>(HttpStatus.OK);
				})
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}