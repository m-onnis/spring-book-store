package onnis.samples.bookstore.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreationDto {
    @NotBlank private String firstName;
    @NotBlank private String lastName;
}
