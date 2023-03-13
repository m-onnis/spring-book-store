package com.env.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.env.bookstore.dto.PublisherDto;
import com.env.bookstore.model.Publisher;
import com.env.bookstore.repository.PublisherRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PublisherService
{
    private final PublisherRepository publisherRepo;

    @Transactional(readOnly = true)
    public List<Publisher> findAll()
    {
        return publisherRepo.findAll();
    }

    @Transactional
    public Publisher create(final PublisherDto publisherDto)
    {
        final Publisher publisher = Publisher.builder()
                .name(publisherDto.getName())
                .build();

        return publisherRepo.save(publisher);
    }
}
