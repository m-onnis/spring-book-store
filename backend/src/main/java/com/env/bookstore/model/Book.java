package com.env.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Book extends BaseEntity {
    @NotBlank private String isbn;
    @NotBlank private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    @Singular
    private Set<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Publisher publisher;
}
