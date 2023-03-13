package com.env.bookstore.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Author extends BaseEntity
{
    @JsonBackReference
    @ManyToMany(mappedBy = "authors")
    Set<Book> books;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
