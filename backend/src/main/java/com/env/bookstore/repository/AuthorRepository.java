package com.env.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.env.bookstore.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Long>
{
}