package onnis.samples.bookstore.controller;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.*;
import onnis.samples.bookstore.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "/authors",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepo;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Author> authors() {
        return authorRepo.findAll();
    }
}
