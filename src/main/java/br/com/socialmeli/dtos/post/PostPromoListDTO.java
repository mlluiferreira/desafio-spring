package br.com.socialmeli.dtos.post;

import java.util.Set;

public class PostPromoListDTO {
    private Long userId;

    private String userName;

    private Set<PostPromoDTO> posts;

    public PostPromoListDTO() { }

    public PostPromoListDTO(Long userId, String userName, Set<PostPromoDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<PostPromoDTO> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostPromoDTO> posts) {
        this.posts = posts;
    }
}
