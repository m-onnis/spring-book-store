package onnis.samples.bookstore.service;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.*;
import onnis.samples.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepo;

    @Transactional
    public Author create(AuthorCreationDto authorDto) {
        Author author = Author.builder()
                .firstName(authorDto.getFirstName())
                .lastName(authorDto.getLastName())
                .build();

        return authorRepo.save(author);
    }
}
