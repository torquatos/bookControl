package com.torquatos.booksystem.book_management_system.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.torquatos.booksystem.book_management_system.utils.TestHelper;
import com.torquatos.booksystem.book_management_system.entity.Book;
import com.torquatos.booksystem.book_management_system.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
public class BookControllerTests {
	
	@MockBean
    BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Book existingBook, newBook, updateBook;

    @Before
    public void setUp() {
        newBook = TestHelper.buildBookWithId();
        existingBook = TestHelper.buildBookWithId();
        updateBook = TestHelper.buildBookWithId();
    }
    
    @Test
    public void should_get_all_books() throws Exception {
        given(bookService.getAllBooks()).willReturn(Arrays.asList(existingBook, updateBook));

        this.mockMvc
                .perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
    
    @Test
    public void should_get_book_by_id() throws Exception {
        given(bookService.getBookById(existingBook.getId())).willReturn(Optional.of(existingBook));

        this.mockMvc
                .perform(get("/api/users/"+existingBook.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(existingBook.getId())))
                .andExpect(jsonPath("$.name", is(existingBook.getName())))
                //.andExpect(jsonPath("$.email", is(existingBook.getEmail())));
    }

