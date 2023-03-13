package com.env.bookstore.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Book extends BaseEntity
{
    @NotNull
    private String isbn;
    @NotNull
    private String title;

    @ManyToMany
    @JsonManagedReference
    @Singular
    private Set<Author> authors;

    @ManyToOne
    @NotNull
    private Publisher publisher;
}
