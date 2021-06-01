package br.com.socialmeli.dtos.user.seller;

import br.com.socialmeli.dtos.user.UserDTO;

public class SellerCountDTO extends UserDTO {
    public Long followers_count = 0L;

    public Long getId() {
        return id;
    }

    public void setFollowers_count(Long followers_count) {
        this.followers_count = followers_count;
    }
}
