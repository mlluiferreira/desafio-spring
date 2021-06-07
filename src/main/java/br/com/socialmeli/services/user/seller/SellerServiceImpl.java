package br.com.socialmeli.services.user.seller;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.exceptions.user.SellerNotFoundException;
import br.com.socialmeli.mapper.user.SellerMapper;
import br.com.socialmeli.repositories.user.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class SellerServiceImpl implements SellerService<Seller> {
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerCountDTO counterSellerFollowers(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));
        return SellerMapper.buildSellerCountDTO(seller);
    }

    @Override
    public Optional<SellerDTO> findById(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElse(null);
        if (seller == null) return Optional.empty();
        return Optional.of(SellerMapper.buildSellerDTO(seller));
    }

    @Override
    public SellerDTO save(CreateUserDTO createUserDTO) {
        Seller seller = SellerMapper.buildSeller(createUserDTO);
        seller = sellerRepository.save(seller);
        return SellerMapper.buildSellerDTO(seller);
    }
}
