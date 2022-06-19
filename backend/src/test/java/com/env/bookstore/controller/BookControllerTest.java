package com.env.bookstore.controller;

import com.env.bookstore.model.Book;
import com.env.bookstore.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @Test
    void books() throws Exception {
        List<Book> bookList = Arrays.asList(
                Book.builder().title("title1").isbn("isbn1").build(),
                Book.builder().title("title2").isbn("isbn2").build());

        // GIVEN
        given(bookService.findAll()).willReturn(bookList);

        // WHEN
        MvcResult result = mvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        // THEN
        String responseBody = result.getResponse().getContentAsString();
        String expectedBody = objectMapper.writeValueAsString(bookList);
        assertThat(responseBody).isEqualToIgnoringWhitespace(expectedBody);
    }

    @Test
    void createBook() {
    }

    @Test
    void deleteBook() {
    }
}