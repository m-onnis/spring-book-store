package onnis.samples.bookstore;

import onnis.samples.bookstore.model.Author;
import onnis.samples.bookstore.model.Book;
import onnis.samples.bookstore.model.Publisher;
import onnis.samples.bookstore.repository.AuthorRepository;
import onnis.samples.bookstore.repository.BookRepository;
import onnis.samples.bookstore.repository.PublisherRepository;
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
