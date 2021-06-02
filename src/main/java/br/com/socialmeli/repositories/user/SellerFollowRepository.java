package br.com.socialmeli.repositories.user;

import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.SellerFollow;
import br.com.socialmeli.entities.users.SellerFollowKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SellerFollowRepository extends PagingAndSortingRepository<SellerFollow, SellerFollowKey> {
    List<Seller> findSellerFollowedByClientId(Long clientId);

    List<Client> findClientFollowingBySellerId(Long sellerId);

    Long countByClientId(Long clientId);

    Long countBySellerId(Long sellerId);

    @Query("select s.seller.id from SellerFollow s WHERE s.client.id = :clientId")
    List<Long> findSellerIdByClientId(Long clientId);
}
