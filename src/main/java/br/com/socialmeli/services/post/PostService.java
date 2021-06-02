package br.com.socialmeli.services.post;

import br.com.socialmeli.dtos.post.CreatePostDTO;
import br.com.socialmeli.dtos.post.PostDTO;

public interface PostService {
    PostDTO createPost(CreatePostDTO createPostDTO);
}
