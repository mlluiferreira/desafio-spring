package br.com.socialmeli.repositories.post;

import br.com.socialmeli.entities.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
}
