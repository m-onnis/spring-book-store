package onnis.samples.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "authors")
    Set<Book> books = new HashSet<>();
}
