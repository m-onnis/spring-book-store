package onnis.samples.bookstore;

import onnis.samples.bookstore.model.Book;
import onnis.samples.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner testApp(BookRepository repo) {
        return args -> {
            Book firstBook = new Book();
            firstBook.setIsbn("XXX-XXXXXX");
            firstBook.setName("First Book");

            Book secondBook = new Book();
            secondBook.setIsbn("YYY-YYYYYY");
            secondBook.setName("Second Book");
            repo.save(firstBook);
            repo.save(secondBook);

            repo.findAll().forEach(System.out::println);
        };
    }
}
