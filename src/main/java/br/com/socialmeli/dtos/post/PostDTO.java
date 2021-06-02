package br.com.socialmeli.dtos.post;

import br.com.socialmeli.dtos.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PostDTO {
    @JsonProperty("id_post")
    private Long id;

    private Long userId;

    @JsonProperty("date")
    private LocalDate creationDate;

    private String category;

    @JsonProperty("detail")
    private ProductDTO product;

    private BigDecimal price;


    public PostDTO() {
    }

    public PostDTO(Long id, Long userId, LocalDate creationDate, String category, ProductDTO product, BigDecimal price) {
        this.id = id;
        this.userId = userId;
        this.creationDate = creationDate;
        this.category = category;
        this.product = product;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
