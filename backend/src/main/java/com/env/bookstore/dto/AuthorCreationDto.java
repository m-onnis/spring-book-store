package com.env.bookstore.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreationDto
{
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
