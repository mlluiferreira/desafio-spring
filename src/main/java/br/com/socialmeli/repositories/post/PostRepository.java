package br.com.socialmeli.repositories.post;

import br.com.socialmeli.entities.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    List<Post> findBySellerIdInAndCreationDateBetweenOrderByCreationDate(List<Long> sellerId, LocalDate startDate, LocalDate endDate);
}
