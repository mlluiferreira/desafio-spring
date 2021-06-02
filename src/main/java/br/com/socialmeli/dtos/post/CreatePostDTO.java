package br.com.socialmeli.dtos.post;

import java.math.BigDecimal;

public class CreatePostDTO {

    private Long userId;

    private String category;

    private Long productId;

    private BigDecimal price;

    public CreatePostDTO() {
    }

    public CreatePostDTO(Long userId, String category, Long productId, BigDecimal price) {
        this.userId = userId;
        this.category = category;
        this.productId = productId;
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
