package br.com.socialmeli.services.post;

import br.com.socialmeli.controllers.SortParam;
import br.com.socialmeli.dtos.post.CreateRegularPostDTO;
import br.com.socialmeli.dtos.post.PostDTO;
import br.com.socialmeli.dtos.post.PostFromSellerByClientDTO;

public interface PostService {
    PostDTO createPost(CreateRegularPostDTO createRegularPostDTO);

    PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId);

    PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId, SortParam sort);
}
