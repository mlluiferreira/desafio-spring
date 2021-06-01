package br.com.socialmeli.services.user.sellerfollower;

public interface SellerFollowService {

    void followSeler(Long clientId, Long sellerId);

    Long countSellerFollowers(Long sellerId);
}
