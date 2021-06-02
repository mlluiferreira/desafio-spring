package br.com.socialmeli.services.post;

import br.com.socialmeli.controllers.SortParam;
import br.com.socialmeli.dtos.post.CreatePostDTO;
import br.com.socialmeli.dtos.post.PostDTO;
import br.com.socialmeli.dtos.post.PostFromSellerByClientDTO;
import org.springframework.data.domain.Sort;

public interface PostService {
    PostDTO createPost(CreatePostDTO createPostDTO);

    PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId);

    PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId, SortParam sort);
}
