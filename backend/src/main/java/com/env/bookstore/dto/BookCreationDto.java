package com.env.bookstore.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookCreationDto {
    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    @NotEmpty
    private List<Long> authors;

    @NotNull
    private Long publisher;
}
