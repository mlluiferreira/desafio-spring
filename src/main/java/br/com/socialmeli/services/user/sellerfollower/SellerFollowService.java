package br.com.socialmeli.services.user.sellerfollower;

import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.SellerFollow;

public interface SellerFollowService {

    void followSeler(Long clientId, Long sellerId);

    Long countSellerFollowers(Long sellerId);
}
