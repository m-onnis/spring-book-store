package onnis.samples.bookstore.controller;

import onnis.samples.bookstore.model.Book;
import onnis.samples.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping(
        path = "/books",
        produces = "application/json")
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book createBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Book> books(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }
}
