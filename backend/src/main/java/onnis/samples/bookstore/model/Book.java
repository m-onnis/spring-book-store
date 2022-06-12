package onnis.samples.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    @NotBlank private String isbn;
    @NotBlank private String title;

    // @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @JsonManagedReference
    @Singular
    private Set<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Publisher publisher;
}
