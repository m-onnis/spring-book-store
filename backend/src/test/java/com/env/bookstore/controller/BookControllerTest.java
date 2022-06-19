package com.env.bookstore.controller;

import com.env.bookstore.dto.BookCreationDto;
import com.env.bookstore.model.Book;
import com.env.bookstore.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @Nested
    class GetBooks {
        @Test
        @DisplayName("should return book list with OK status")
        void getBooksShouldReturnBookListAndOkStatus() throws Exception {
            List<Book> bookList = Arrays.asList(
                    Book.builder().title("title1").isbn("isbn1").build(),
                    Book.builder().title("title2").isbn("isbn2").build());

            given(bookService.findAll()).willReturn(bookList);

            MvcResult result = mvc.perform(get("/books")
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andReturn();

            String actualBody = result.getResponse().getContentAsString();
            String expectedBody = objectMapper.writeValueAsString(bookList);
            assertThat(actualBody).isEqualToIgnoringWhitespace(expectedBody);
        }

        @Test
        @DisplayName("should return book list (empty) with OK status")
        void getEmptyBookLists() throws Exception {
            MvcResult result = mvc.perform(get("/books")
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andReturn();

            String actualBody = result.getResponse().getContentAsString();
            String expectedBody = objectMapper.writeValueAsString(List.of());
            assertThat(actualBody).isEqualToIgnoringWhitespace(expectedBody);
        }
    }

    @Nested
    class CreateBook {
        @Test
        @DisplayName("should succeed with valid parameter and return status CREATED")
        void createBook() throws Exception {
            BookCreationDto bookDto = BookCreationDto.builder()
                    .title("title1")
                    .isbn("isbn1")
                    .authors(List.of(1L))
                    .publisher(1L)
                    .build();

            MvcResult result = mvc.perform(post("/books")
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .content(objectMapper.writeValueAsString(bookDto)))
                    .andExpect(status().isCreated())
                    .andReturn();
        }

        @Test
        @DisplayName("should fail with invalid parameters and return status BAD REQUEST")
        void createInvalidBook() throws Exception {
            BookCreationDto bookDto = BookCreationDto.builder()
                    // .title("title1")
                    .isbn("isbn1")
                    //.authors(List.of(1L))
                    .publisher(1L)
                    .build();

            MvcResult result = mvc.perform(post("/books")
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .content(objectMapper.writeValueAsString(bookDto)))
                    .andExpect(status().isBadRequest())
                    .andReturn();
        }
    }

    @Nested
    class DeleteBook {
        @Test
        @DisplayName("should delete an existing book and return OK")
        void deleteBook() throws Exception {
            MvcResult result = mvc.perform(delete("/books/{id}", "60")
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                    .andReturn();
        }

        @Test
        @DisplayName("should fail deleting an entity that doesn't exists and return NOT FOUND")
        void deleteNotExistingBook() throws Exception {
            doThrow(EmptyResultDataAccessException.class).when(bookService).delete(anyLong());

            MvcResult result = mvc.perform(delete("/books/{id}", "60")
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isNotFound())
                    .andReturn();
        }
    }
}
