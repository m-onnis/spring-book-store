package onnis.samples.bookstore.repository;

import onnis.samples.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long>  {
}
