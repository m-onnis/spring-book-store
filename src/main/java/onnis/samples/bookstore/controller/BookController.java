package onnis.samples.bookstore.controller;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.Book;
import onnis.samples.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

@RestController
@RequestMapping(
        path = "/books",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @Valid annotation here triggers automatically 400 (Bad Request) when the request body is a not valid Book
    Book createBook(@Valid @RequestBody Book book) {
        return bookRepo.save(book);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Book> books(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }
}
