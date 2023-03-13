package com.env.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.env.bookstore.dto.AuthorCreationDto;
import com.env.bookstore.model.Author;
import com.env.bookstore.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthorService
{
    private final AuthorRepository authorRepo;

    @Transactional(readOnly = true)
    public List<Author> findAll()
    {
        return authorRepo.findAll();
    }

    @Transactional
    public Author create(final AuthorCreationDto authorDto)
    {
        final Author author = Author.builder()
                .firstName(authorDto.getFirstName())
                .lastName(authorDto.getLastName())
                .build();

        return authorRepo.save(author);
    }
}
