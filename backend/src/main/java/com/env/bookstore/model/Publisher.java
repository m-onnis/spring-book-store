package com.env.bookstore.model;

import javax.persistence.Entity;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@NoArgsConstructor

@Entity
public class Publisher extends NamedEntity
{
}
