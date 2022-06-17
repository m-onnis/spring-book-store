package com.env.bookstore.controller;

import lombok.RequiredArgsConstructor;
import com.env.bookstore.dto.BookCreationDto;
import com.env.bookstore.model.*;
import com.env.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "/books",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    List<Book> books() {
        return bookService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book createBook(@Valid @RequestBody BookCreationDto bookDto) {
        return bookService.create(bookDto);
    }

    @DeleteMapping("{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}
