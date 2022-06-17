package com.env.bookstore.repository;

import com.env.bookstore.model.Book;
import com.env.bookstore.dto.BookDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = {"authors", "publisher"})
    @Override
    List<Book> findAll();

    List<BookDto> findAllProjectedBy();
}
