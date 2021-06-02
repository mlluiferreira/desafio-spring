package br.com.socialmeli.services.user.seller;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Seller;

import java.util.Optional;

public interface SellerService<T extends Seller> {
    SellerFollowersDTO sellerFollowers(Long sellerId);

    SellerCountDTO counterSellerFollowers(Long sellerId);

    Optional<SellerDTO> findById(Long selerId);

    SellerDTO save(CreateUserDTO createUserDTO);
}
