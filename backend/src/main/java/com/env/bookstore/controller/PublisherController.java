package com.env.bookstore.controller;

import lombok.RequiredArgsConstructor;
import com.env.bookstore.model.Publisher;
import com.env.bookstore.dto.PublisherDto;
import com.env.bookstore.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "/publishers",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping
    List<Publisher> publishers() {
        return publisherService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Publisher createPublisher(@Valid @RequestBody PublisherDto publisherDto) {
        return publisherService.create(publisherDto);
    }
}
