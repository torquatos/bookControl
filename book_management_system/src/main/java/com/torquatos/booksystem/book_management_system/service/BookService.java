package com.torquatos.booksystem.book_management_system.service;

import com.torquatos.booksystem.book_management_system.*;
import com.torquatos.booksystem.book_management_system.entity.Book;
import com.torquatos.booksystem.book_management_system.repo.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookById(Long id){
		return bookRepository.findById(id);
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
}
