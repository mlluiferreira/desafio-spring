package br.com.socialmeli.services.user;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.UserDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;

public interface UserService {
    void followSeler(Long clientId, Long sellerId);

    SellerFollowersDTO sellerFollowers(Long sellerId);

    SellerCountDTO counterSellerFollowers(Long sellerId);

    ClientFollowedDTO clientFollowed(Long clientId);

    UserDTO save(CreateUserDTO createUserDTO);
}
