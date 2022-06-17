package com.env.bookstore.service;

import lombok.RequiredArgsConstructor;
import com.env.bookstore.model.Author;
import com.env.bookstore.model.Book;
import com.env.bookstore.dto.BookCreationDto;
import com.env.bookstore.model.Publisher;
import com.env.bookstore.repository.AuthorRepository;
import com.env.bookstore.repository.BookRepository;
import com.env.bookstore.repository.PublisherRepository;
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

    @Transactional
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
