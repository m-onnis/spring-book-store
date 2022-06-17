package com.env.bookstore;

import com.env.bookstore.model.Author;
import com.env.bookstore.model.Book;
import com.env.bookstore.model.Publisher;
import com.env.bookstore.repository.AuthorRepository;
import com.env.bookstore.repository.BookRepository;
import com.env.bookstore.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }
}
