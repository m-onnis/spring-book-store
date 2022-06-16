package onnis.samples.bookstore.service;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.Author;
import onnis.samples.bookstore.model.Book;
import onnis.samples.bookstore.dto.BookCreationDto;
import onnis.samples.bookstore.model.Publisher;
import onnis.samples.bookstore.repository.AuthorRepository;
import onnis.samples.bookstore.repository.BookRepository;
import onnis.samples.bookstore.repository.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final PublisherRepository publisherRepo;

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Transactional
    public Book create(BookCreationDto bookDto) {
        List<Author> authors = authorRepo.findAllById(bookDto.getAuthors());

        // java.util.NoSuchElementException if not found
        Publisher publisher = publisherRepo.findById(bookDto.getPublisher())
                .orElseThrow();

        Book book = Book.builder()
                .isbn(bookDto.getIsbn())
                .title(bookDto.getTitle())
                .authors(authors)
                .publisher(publisher)
                .build();

        return bookRepo.save(book);
    }
}
