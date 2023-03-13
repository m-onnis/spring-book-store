package com.env.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.env.bookstore.dto.BookCreationDto;
import com.env.bookstore.dto.BookDto;
import com.env.bookstore.model.Author;
import com.env.bookstore.model.Book;
import com.env.bookstore.model.Publisher;
import com.env.bookstore.repository.AuthorRepository;
import com.env.bookstore.repository.BookRepository;
import com.env.bookstore.repository.PublisherRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BookService
{
    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final PublisherRepository publisherRepo;

    @Transactional(readOnly = true)
    public List<Book> findAll()
    {
        return bookRepo.findAll();
    }

    @Transactional
    public List<BookDto> finAllProjected()
    {
        return bookRepo.findAllProjectedBy(BookDto.class);
    }

    @Transactional
    public Book create(final BookCreationDto bookDto)
    {
        final List<Author> authors = authorRepo.findAllById(bookDto.getAuthors());

        // java.util.NoSuchElementException if not found
        final Publisher publisher = publisherRepo.findById(bookDto.getPublisher())
            .orElseThrow();

        final Book book = Book.builder()
            .isbn(bookDto.getIsbn())
            .title(bookDto.getTitle())
            .authors(authors)
            .publisher(publisher)
            .build();

        return bookRepo.save(book);
    }

    @Transactional
    public void delete(final Long id)
    {
        bookRepo.deleteById(id);
    }
}
