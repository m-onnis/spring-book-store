package onnis.samples.bookstore.controller;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.Publisher;
import onnis.samples.bookstore.repository.PublisherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(
        path = "/publishers",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherRepository publisherRepo;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Publisher> publishers() {
        return publisherRepo.findAll();
    }
}
