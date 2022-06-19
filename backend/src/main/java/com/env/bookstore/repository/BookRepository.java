package com.env.bookstore.repository;

import com.env.bookstore.model.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = {"authors", "publisher"})
    @Override
    List<Book> findAll();

    <T> List<T> findAllProjectedBy(Class<T> clazz);
}
