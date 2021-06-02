package br.com.socialmeli.services.user.seller;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.exceptions.user.SellerNotFoundException;
import br.com.socialmeli.repositories.user.SellerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class SellerServiceImpl implements SellerService<Seller> {
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    private SellerDTO getSellerDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        BeanUtils.copyProperties(seller, sellerDTO);
        return sellerDTO;
    }

    @Override
    public SellerCountDTO counterSellerFollowers(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));

        SellerCountDTO sellerCountDTO = new SellerCountDTO();
        BeanUtils.copyProperties(seller, sellerCountDTO);
        sellerCountDTO.setFollowers_count((long) seller.getFollowers().size());

        return sellerCountDTO;
    }

    @Override
    public Optional<SellerDTO> findById(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElse(null);
        if (seller == null) return Optional.empty();
        SellerDTO sellerDTO = getSellerDTO(seller);
        return Optional.of(sellerDTO);
    }

    @Override
    public SellerDTO save(CreateUserDTO createUserDTO) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(createUserDTO, seller);
        seller = sellerRepository.save(seller);
        SellerDTO sellerDTO = getSellerDTO(seller);
        return sellerDTO;
    }
}
