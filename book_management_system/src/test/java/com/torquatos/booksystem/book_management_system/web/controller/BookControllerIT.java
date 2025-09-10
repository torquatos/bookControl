package com.torquatos.booksystem.book_management_system.web.controller;

import com.torquatos.booksystem.book_management_system.entity.Book;
import com.torquatos.booksystem.book_management_system.repo.BookRepository;
import com.torquatos.booksystem.book_management_system.utils.BaseIntegrationTest;
import com.torquatos.booksystem.book_management_system.utils.TestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

public class BookControllerIT extends BaseIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TestRestTemplate restTemplate;

    Book existingBook, newBook, updateBook;

    @Before
    public void setUp() {
        newBook = TestHelper.buildBook();

        existingBook = TestHelper.buildBook();
        existingBook = bookRepository.save(existingBook);

        updateBook = TestHelper.buildBook();
        updateBook = bookRepository.save(updateBook);
    }

    @After
    public void tearDown() {
        if(newBook.getId() != null) {
            bookRepository.deleteById(newBook.getId());
        }
        bookRepository.deleteAll(bookRepository.findAllById(asList(existingBook.getId(), updateBook.getId())));
    }

    @Test
    public void should_get_all_books() {
        ResponseEntity<Book[]> responseEntity = restTemplate.getForEntity("/api/books", Book[].class);
        List<Book> books = asList(responseEntity.getBody());
        assertThat(books).isNotEmpty();
    }

    @Test
    public void should_get_book_by_id() {
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity("/api/books/"+existingBook.getId(), Book.class);
        Book book = responseEntity.getBody();
        assertThat(book).isNotNull();
    }

    @Test
    public void should_create_book() {
        HttpEntity<Book> request = new HttpEntity<>(newBook);
        ResponseEntity<Book> responseEntity = restTemplate.postForEntity("/api/books", request, Book.class);
        Book savedBook = responseEntity.getBody();
        assertThat(savedBook.getId()).isNotNull();
    }

    @Test
    public void should_update_book() {
        HttpEntity<Book> request = new HttpEntity<>(updateBook);
        restTemplate.put("/api/books/"+updateBook.getId(), request, Book.class);
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity("/api/books/"+updateBook.getId(), Book.class);
        Book updatedBook = responseEntity.getBody();
        assertThat(updatedBook.getId()).isEqualTo(updateBook.getId());
        //assertThat(updatedBook.getEmail()).isEqualTo(updateUser.getEmail());
    }

    @Test
    public void should_delete_book() {
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity("/api/books/"+existingBook.getId(), Book.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        restTemplate.delete("/api/books/"+existingBook.getId());
        responseEntity = restTemplate.getForEntity("/api/books/"+existingBook.getId(), Book.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(NOT_FOUND);
    }
}