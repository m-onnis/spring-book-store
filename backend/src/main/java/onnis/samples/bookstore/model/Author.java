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
@Table(name = "authors")
public class Author extends BaseEntity {
    @NotBlank private String firstName;
    @NotBlank private String lastName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    Set<Book> books;
}
