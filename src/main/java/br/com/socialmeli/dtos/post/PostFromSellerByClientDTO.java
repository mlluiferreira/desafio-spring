package br.com.socialmeli.dtos.post;

import java.util.List;

public class PostFromSellerByClientDTO {
    private Long userId;

    private List<PostDTO> posts;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
