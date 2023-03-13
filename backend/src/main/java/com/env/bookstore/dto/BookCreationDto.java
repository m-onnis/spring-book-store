package com.env.bookstore.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class BookCreationDto
{
    @NotBlank
    private String isbn;
    @NotBlank
    private String title;
    @NotEmpty
    private List<Long> authors;
    @NotNull
    private Long publisher;
}
