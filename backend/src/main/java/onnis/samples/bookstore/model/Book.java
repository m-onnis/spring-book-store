package onnis.samples.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    @NotBlank private String isbn;
    @NotBlank private String title;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    // @Builder.Default
    @Singular
    Set<Author> authors;
}