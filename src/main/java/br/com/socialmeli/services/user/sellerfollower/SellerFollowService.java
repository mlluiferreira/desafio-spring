package br.com.socialmeli.services.user.sellerfollower;

import java.util.List;

public interface SellerFollowService {

    void followSeler(Long clientId, Long sellerId);

    Long countSellerFollowers(Long sellerId);

    List<Long> sellersIdFollowedByClient(Long clientId);

    void unfollowSeller(Long clientId, Long sellerId);
}
