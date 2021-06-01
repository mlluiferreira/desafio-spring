package br.com.socialmeli.dtos.user.client;

import br.com.socialmeli.dtos.user.UserDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;

import java.util.Set;

public class ClientFollowedDTO extends UserDTO {
    public Set<SellerDTO> followed;

    public Set<SellerDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<SellerDTO> followed) {
        this.followed = followed;
    }
}
