package br.com.socialmeli.dtos.post;

import java.math.BigDecimal;

public class CreatePromoPostDTO extends CreateRegularPostDTO {

    private Boolean hasPromo = true;

    private BigDecimal discount = new BigDecimal(0);

    public CreatePromoPostDTO() {
    }

    public CreatePromoPostDTO(Long userId, String category, Long productId, BigDecimal price, Boolean hasPromo, BigDecimal discount) {
        super(userId, category, productId, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
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
