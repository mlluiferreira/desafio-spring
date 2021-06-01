package br.com.socialmeli.services.user.seller;

import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.services.user.base.BaseUserTypeService;

public interface SellerService<T extends Seller> extends BaseUserTypeService<T> {
    SellerFollowersDTO sellerFollowers(Long sellerId);

    SellerCountDTO counterSellerFollowers(Long sellerId);
}
