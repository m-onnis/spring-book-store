package com.env.bookstore.model;

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
public class Author extends BaseEntity {
    @NotBlank private String firstName;
    @NotBlank private String lastName;

    @JsonBackReference
    @ManyToMany(mappedBy = "authors")
    Set<Book> books;
}
