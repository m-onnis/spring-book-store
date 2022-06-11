package onnis.samples.bookstore.controller;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.Book;
import onnis.samples.bookstore.repository.BookRepository;
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
    private final BookRepository bookRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book createBook(@Valid @RequestBody Book book) {
        // @Valid annotation here triggers automatically 400 (Bad Request)
        // when the request body is a not valid Book
        return bookRepo.save(book);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Book> books() {
        return bookRepo.findAll();
    }
}
