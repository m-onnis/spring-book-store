package com.env.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.env.bookstore.dto.BookCreationDto;
import com.env.bookstore.model.Book;
import com.env.bookstore.service.BookService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "/books",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BookController
{
    private final BookService bookService;

    @GetMapping
    List<Book> books()
    {
        return bookService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book createBook(@Valid @RequestBody final BookCreationDto bookDto)
    {
        return bookService.create(bookDto);
    }

    @DeleteMapping("{id}")
    void deleteBook(@PathVariable final Long id)
    {
        bookService.delete(id);
    }
}
