package br.com.socialmeli.services.user;

import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.SellerFollow;
import br.com.socialmeli.repositories.user.SellerFollowRepository;
import org.springframework.stereotype.Service;

@Service
class SellerFollowService {
    private final SellerFollowRepository sellerFollowRepository;

    public SellerFollowService(SellerFollowRepository sellerFollowRepository) {
        this.sellerFollowRepository = sellerFollowRepository;
    }

    public SellerFollow follow(Client client, Seller seller) {
        SellerFollow sellerFollow = new SellerFollow();
        sellerFollow.setSeller(seller);
        sellerFollow.setClient(client);
        return sellerFollowRepository.save(sellerFollow);
    }

    public Long countSellerFollowers(Long sellerId) {
        return sellerFollowRepository.countBySellerId(sellerId);
    }
}
