package onnis.samples.bookstore.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public class NamedEntity extends BaseEntity {
    @NotBlank private String name;
}
