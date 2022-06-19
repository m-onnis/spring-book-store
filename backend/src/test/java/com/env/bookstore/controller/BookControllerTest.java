package com.env.bookstore.controller;

import com.env.bookstore.model.Book;
import com.env.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {BookController.class})
class BookControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    void books() throws Exception {
        Book b1 = Book.builder().title("title1").isbn("isbn1").build();
        Book b2 = Book.builder().title("title2").isbn("isbn2").build();

        given(bookService.findAll()).willReturn(Arrays.asList(b1, b2));

        mvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void createBook() {
    }

    @Test
    void deleteBook() {
    }
}