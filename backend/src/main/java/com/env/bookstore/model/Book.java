package com.env.bookstore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Book extends BaseEntity {
    @NotNull private String isbn;
    @NotNull private String title;

    @ManyToMany
    @JsonManagedReference
    @Singular
    private Set<Author> authors;

    @ManyToOne
    @NotNull
    private Publisher publisher;
}
