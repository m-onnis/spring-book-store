package com.env.bookstore.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public class NamedEntity extends BaseEntity {
    @NotNull
    private String name;
}
