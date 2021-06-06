package br.com.socialmeli.repositories.post;

import br.com.socialmeli.entities.post.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    List<Post> findBySellerIdInAndDateBetween(List<Long> sellerId, LocalDate startDate, LocalDate endDate);

    List<Post> findBySellerIdInAndDateBetween(List<Long> sellerId, LocalDate startDate, LocalDate endDate, Sort sort);

    Long countBySellerIdAndHasPromoTrue(Long sellerId);

    List<Post> findBySellerIdAndHasPromoTrue(Long sellerId);
}
