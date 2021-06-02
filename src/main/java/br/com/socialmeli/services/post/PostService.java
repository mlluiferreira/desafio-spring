package br.com.socialmeli.services.post;

import br.com.socialmeli.dtos.post.CreatePostDTO;
import br.com.socialmeli.dtos.post.PostDTO;
import br.com.socialmeli.dtos.post.PostFromSellerByClientDTO;

public interface PostService {
    PostDTO createPost(CreatePostDTO createPostDTO);

    PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId);
}
