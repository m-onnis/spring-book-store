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

    @Bean
    public CommandLineRunner testApp(BookRepository bookRepo, AuthorRepository authorRepo, PublisherRepository publisherRepo) {
        return args -> {
            Author onnis = Author.builder().firstName("Michele").lastName("Onnis").build();
            Author pintus = Author.builder().firstName("Enrico").lastName("Pintus").build();
            authorRepo.save(onnis);
            authorRepo.save(pintus);

            Publisher manning = Publisher.builder().name("Manning").build();
            Publisher oreilly = Publisher.builder().name("Oreilly").build();
            publisherRepo.save(manning);
            publisherRepo.save(oreilly);

            Book firstBook = Book.builder()
                    .isbn("XXX-XXXXXX")
                    .title("First Book")
                    .author(onnis)
                    .author(pintus)
                    .publisher(manning)
                    .build();

            Book secondBook = Book.builder()
                    .isbn("YYY-YYYYYY")
                    .title("Second Book")
                    .author(onnis)
                    .publisher(oreilly)
                    .build();

            bookRepo.save(firstBook);
            bookRepo.save(secondBook);

            bookRepo.findAll().forEach(System.out::println);
        };
    }
}
