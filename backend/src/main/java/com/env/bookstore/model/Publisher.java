package com.env.bookstore.model;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@NoArgsConstructor

@Entity
@Table(name = "publishers")
public class Publisher extends NamedEntity {
}
