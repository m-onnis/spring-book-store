package onnis.samples.bookstore.service;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.Publisher;
import onnis.samples.bookstore.model.PublisherDto;
import onnis.samples.bookstore.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepo;

    @Transactional
    public Publisher create(PublisherDto publisherDto) {
        Publisher publisher = Publisher.builder()
                .name(publisherDto.getName())
                .build();

        return publisherRepo.save(publisher);
    }
}
