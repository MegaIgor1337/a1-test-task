package a1.test.task.task3.service;

import a1.test.task.task3.dto.PostingDto;
import a1.test.task.task3.entity.Posting;
import a1.test.task.task3.mapper.PostingMapper;
import a1.test.task.task3.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;
    private final PostingMapper postingMapper;
    public void savePostings(List<Posting> postings) {
        postingRepository.saveAll(postings);
    }

    public List<PostingDto> getPostingsByParams(LocalDate start, LocalDate end, Boolean authorized) {
        if (authorized == null) {
            return postingRepository.findByDocDateBetween(start, end).stream()
                    .map(postingMapper::fromEntityToDto).toList();
        } else {
            return postingRepository.findByDocDateBetweenAndByAuthorizedDelivery(start, end, authorized)
                    .stream().map(postingMapper::fromEntityToDto).toList();
        }
    }
}
