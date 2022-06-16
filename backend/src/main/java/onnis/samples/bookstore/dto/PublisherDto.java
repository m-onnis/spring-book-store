package onnis.samples.bookstore.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDto {
    @NotBlank private String name;
}