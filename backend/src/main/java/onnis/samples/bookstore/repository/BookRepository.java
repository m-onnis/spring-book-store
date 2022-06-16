package onnis.samples.bookstore.repository;

import onnis.samples.bookstore.model.Book;
import onnis.samples.bookstore.dto.BookDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = {"authors", "publisher"})
    @Override
    List<Book> findAll();

    List<BookDto> findAllProjectedBy();
}
