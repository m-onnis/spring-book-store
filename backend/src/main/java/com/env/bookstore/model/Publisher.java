package com.env.bookstore.model;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@SuperBuilder
@NoArgsConstructor

@Entity
public class Publisher extends NamedEntity {
}
