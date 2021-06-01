package br.com.socialmeli.dtos.user.seller;

import br.com.socialmeli.dtos.user.UserDTO;
import br.com.socialmeli.dtos.user.client.ClientDTO;

import java.util.Set;

public class SellerFollowersDTO extends UserDTO {
    public Set<ClientDTO> followers;

    public Set<ClientDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<ClientDTO> followers) {
        this.followers = followers;
    }
}
