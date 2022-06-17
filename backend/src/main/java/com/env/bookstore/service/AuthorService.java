package com.env.bookstore.service;

import lombok.RequiredArgsConstructor;
import com.env.bookstore.dto.AuthorCreationDto;
import com.env.bookstore.model.*;
import com.env.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepo;


    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return authorRepo.findAll();
    }
    @Transactional
    public Author create(AuthorCreationDto authorDto) {
        Author author = Author.builder()
                .firstName(authorDto.getFirstName())
                .lastName(authorDto.getLastName())
                .build();

        return authorRepo.save(author);
    }
}
