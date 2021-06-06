package br.com.socialmeli.services.user.sellerfollower;

import br.com.socialmeli.dtos.SortParam;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;

import java.util.List;

public interface SellerFollowService {

    void followSeler(Long clientId, Long sellerId);

    List<Long> sellersIdFollowedByClient(Long clientId);

    SellerFollowersDTO sellerFollowers(Long sellerId, SortParam sortParam);

    SellerFollowersDTO sellerFollowers(Long sellerId);

    void unfollowSeller(Long clientId, Long sellerId);

    ClientFollowedDTO clientFollowed(Long clientId);

    ClientFollowedDTO clientFollowed(Long sellerId, SortParam sortParam);
}
