package onnis.samples.bookstore.service;

import lombok.RequiredArgsConstructor;
import onnis.samples.bookstore.model.Publisher;
import onnis.samples.bookstore.dto.PublisherDto;
import onnis.samples.bookstore.repository.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepo;

    @Transactional(readOnly = true)
    public List<Publisher> findAll() {
        return publisherRepo.findAll();
    }

    @Transactional
    public Publisher create(PublisherDto publisherDto) {
        Publisher publisher = Publisher.builder()
                .name(publisherDto.getName())
                .build();

        return publisherRepo.save(publisher);
    }
}
