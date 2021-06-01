package br.com.socialmeli.services.user;

import br.com.socialmeli.dtos.user.UserDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.exceptions.user.SellerNotFoundException;
import br.com.socialmeli.repositories.user.SellerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
class SellerService extends BaseUserTypeService<Seller> {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        super(sellerRepository, Seller.class);
        this.sellerRepository = sellerRepository;
    }

    public SellerFollowersDTO sellerFollowers(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));

        Set<UserDTO> followers = seller.getFollowers().stream().map(follower -> {
            Client client = follower.getClient();
            return new UserDTO(client.getId(), client.getName());
        }).collect(Collectors.toSet());

        SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO();
        BeanUtils.copyProperties(seller, sellerFollowersDTO);
        sellerFollowersDTO.setFollowers(followers);

        return sellerFollowersDTO;
    }
}
