package onnis.samples.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String isbn;

    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(name="book_authors",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id"))
    Set<Author> authors = new HashSet<>();
}
