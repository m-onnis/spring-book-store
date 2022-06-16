package onnis.samples.bookstore.controller;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.Publisher;
import onnis.samples.bookstore.dto.PublisherDto;
import onnis.samples.bookstore.service.PublisherService;
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
    @ResponseStatus(HttpStatus.OK)
    List<Publisher> publishers() {
        return publisherService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Publisher createPublisher(@Valid @RequestBody PublisherDto publisherDto) {
        return publisherService.create(publisherDto);
    }
}
