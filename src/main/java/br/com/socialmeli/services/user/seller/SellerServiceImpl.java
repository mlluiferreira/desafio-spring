package br.com.socialmeli.services.user.seller;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.exceptions.user.SellerNotFoundException;
import br.com.socialmeli.repositories.user.SellerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class SellerServiceImpl implements SellerService<Seller> {
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerFollowersDTO sellerFollowers(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));

        Set<ClientDTO> followers = seller.getFollowers().stream().map(follower -> {
            Client client = follower.getClient();
            return new ClientDTO(client.getId(), client.getName());
        }).collect(Collectors.toSet());

        SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO();
        BeanUtils.copyProperties(seller, sellerFollowersDTO);
        sellerFollowersDTO.setFollowers(followers);

        return sellerFollowersDTO;
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
        SellerDTO sellerDTO = new SellerDTO();
        BeanUtils.copyProperties(seller, sellerDTO);
        return Optional.of(sellerDTO);
    }

    @Override
    public SellerDTO save(CreateUserDTO createUserDTO) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(createUserDTO, seller);
        seller = sellerRepository.save(seller);
        SellerDTO sellerDTO = new SellerDTO();
        BeanUtils.copyProperties(seller, sellerDTO);
        return sellerDTO;
    }
}
