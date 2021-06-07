package br.com.socialmeli.mapper.user;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.entities.users.Seller;
import org.springframework.beans.BeanUtils;

public class SellerMapper {
    public static SellerDTO buildSellerDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        BeanUtils.copyProperties(seller, sellerDTO);
        return sellerDTO;
    }

    public static Seller buildSeller(CreateUserDTO createUserDTO) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(createUserDTO, seller);
        return seller;
    }

    public static SellerCountDTO buildSellerCountDTO(Seller seller) {
        SellerCountDTO sellerCountDTO = new SellerCountDTO();
        BeanUtils.copyProperties(seller, sellerCountDTO);
        sellerCountDTO.setFollowers_count((long) seller.getFollowers().size());
        return sellerCountDTO;
    }
}
