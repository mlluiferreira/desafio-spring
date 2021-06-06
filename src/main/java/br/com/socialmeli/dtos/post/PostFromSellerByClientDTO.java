package br.com.socialmeli.dtos.post;

import java.util.List;

public class PostFromSellerByClientDTO {
    private Long userId;

    private List<PostRegularDTO> posts;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PostRegularDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostRegularDTO> posts) {
        this.posts = posts;
    }
}
