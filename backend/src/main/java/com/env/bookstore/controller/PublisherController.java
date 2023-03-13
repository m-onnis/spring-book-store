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

import com.env.bookstore.dto.PublisherDto;
import com.env.bookstore.model.Publisher;
import com.env.bookstore.service.PublisherService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "/publishers",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PublisherController
{
    private final PublisherService publisherService;

    @GetMapping
    List<Publisher> publishers()
    {
        return publisherService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Publisher createPublisher(@Valid @RequestBody final PublisherDto publisherDto)
    {
        return publisherService.create(publisherDto);
    }
}
