package br.com.socialmeli.dtos.post;

import br.com.socialmeli.dtos.product.ProductDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PostPromoDTO extends PostRegularDTO {
    private Boolean hasPromo;

    private BigDecimal discount;

    public PostPromoDTO() {
    }

    public PostPromoDTO(Long id, Long userId, LocalDate date, String category, ProductDTO product, BigDecimal price) {
        super(id, userId, date, category, product, price);
        this.hasPromo = hasPromo;
    }

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
