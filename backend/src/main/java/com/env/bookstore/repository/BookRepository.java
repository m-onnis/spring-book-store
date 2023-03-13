package com.env.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.env.bookstore.model.Book;


public interface BookRepository extends JpaRepository<Book, Long>
{
    @EntityGraph(attributePaths = {"authors", "publisher"})
    @Override
    List<Book> findAll();

    <T> List<T> findAllProjectedBy(Class<T> clazz);
}
