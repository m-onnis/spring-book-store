package com.env.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.env.bookstore.model.Publisher;


public interface PublisherRepository extends JpaRepository<Publisher, Long>
{
}
