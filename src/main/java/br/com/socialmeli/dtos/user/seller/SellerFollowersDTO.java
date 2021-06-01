package br.com.socialmeli.dtos.user.seller;

import br.com.socialmeli.dtos.user.UserDTO;

import java.util.Set;

public class SellerFollowersDTO extends UserDTO {
    public Set<UserDTO> followers;

    public Set<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserDTO> followers) {
        this.followers = followers;
    }
}
