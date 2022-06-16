package onnis.samples.bookstore.controller;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.dto.AuthorCreationDto;
import onnis.samples.bookstore.model.*;
import onnis.samples.bookstore.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "/authors",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Author> authors() {
        return authorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Author createAuthor(@Valid @RequestBody AuthorCreationDto authorDto) {
        return authorService.create(authorDto);
    }
}
