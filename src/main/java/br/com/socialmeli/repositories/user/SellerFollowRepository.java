package br.com.socialmeli.repositories.user;

import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.SellerFollow;
import br.com.socialmeli.entities.users.SellerFollowKey;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SellerFollowRepository extends PagingAndSortingRepository<SellerFollow, SellerFollowKey> {
    List<Seller> findSellerFollowedByClientId(Long clientId);

    @Query("select s.client from SellerFollow s where s.seller.id = :sellerId")
    List<Client> findClientFollowingBySellerId(Long sellerId, Sort sort);

    @Query("select s.seller from SellerFollow s where s.client.id = :clientId")
    List<Seller> findSellerFollowingBySellerId(Long clientId, Sort sort);

    Long countByClientId(Long clientId);

    Long countBySellerId(Long sellerId);

    @Query("select s.seller.id from SellerFollow s WHERE s.client.id = :clientId")
    List<Long> findSellerIdByClientId(Long clientId);
}
