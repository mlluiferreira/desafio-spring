package br.com.socialmeli.dtos.post;

import br.com.socialmeli.dtos.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PostRegularDTO {
    @JsonProperty("id_post")
    private Long id;

    private Long userId;

    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private String category;

    @JsonProperty("detail")
    private ProductDTO product;

    private BigDecimal price;

    public PostRegularDTO() {
    }

    public PostRegularDTO(Long id, Long userId, LocalDate date, String category, ProductDTO product, BigDecimal price) {
        this.id = id;
        this.userId = userId;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
