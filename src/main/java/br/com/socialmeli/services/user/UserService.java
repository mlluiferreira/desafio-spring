package br.com.socialmeli.services.user;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.UserDTO;
import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;

import java.util.List;

public interface UserService {
    void followSeler(Long clientId, Long sellerId);

    SellerFollowersDTO sellerFollowers(Long sellerId);

    SellerCountDTO counterSellerFollowers(Long sellerId);

    List<Long> sellersIdFollowedByClient(Long clientId);

    ClientFollowedDTO clientFollowed(Long clientId);

    UserDTO save(CreateUserDTO createUserDTO);

    SellerDTO findSellerById(Long userId);

    ClientDTO findClientById(Long clientId);
}
