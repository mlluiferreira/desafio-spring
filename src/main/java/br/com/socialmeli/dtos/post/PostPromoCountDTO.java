package br.com.socialmeli.dtos.post;

public class PostPromoCountDTO {
    private Long userId;

    private String userName;

    private Long promoproducts_counts;

    public PostPromoCountDTO() { }

    public PostPromoCountDTO(Long userId, String userName, Long promoproducts_counts) {
        this.userId = userId;
        this.userName = userName;
        this.promoproducts_counts = promoproducts_counts;
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

    public Long getPromoproducts_counts() {
        return promoproducts_counts;
    }

    public void setPromoproducts_counts(Long promoproducts_counts) {
        this.promoproducts_counts = promoproducts_counts;
    }
}
