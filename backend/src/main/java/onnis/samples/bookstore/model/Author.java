package onnis.samples.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
    @NotBlank private String firstName;
    @NotBlank private String lastName;

    // @JsonIgnore
    @JsonBackReference
    @ManyToMany(mappedBy = "authors")
    Set<Book> books;
}
