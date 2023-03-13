package com.env.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.env.bookstore.dto.AuthorCreationDto;
import com.env.bookstore.model.Author;
import com.env.bookstore.service.AuthorService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "/authors",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthorController
{
    private final AuthorService authorService;

    @GetMapping
    List<Author> authors()
    {
        return authorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Author createAuthor(@Valid @RequestBody final AuthorCreationDto authorDto)
    {
        return authorService.create(authorDto);
    }
}
