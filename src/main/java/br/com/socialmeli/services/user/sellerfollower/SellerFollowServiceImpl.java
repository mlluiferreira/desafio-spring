package br.com.socialmeli.services.user.sellerfollower;

import br.com.socialmeli.dtos.SortParam;
import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.SellerFollow;
import br.com.socialmeli.entities.users.SellerFollowKey;
import br.com.socialmeli.exceptions.user.ClientAlreadyFollowSellerException;
import br.com.socialmeli.exceptions.user.ClientNotFoundException;
import br.com.socialmeli.exceptions.user.SellerNotFoundException;
import br.com.socialmeli.exceptions.user.UserCantFollowHimSelfException;
import br.com.socialmeli.exceptions.user.UserNotFollowSellerException;
import br.com.socialmeli.mapper.user.SellerFollowMapper;
import br.com.socialmeli.repositories.user.SellerFollowRepository;
import br.com.socialmeli.services.SortService;
import br.com.socialmeli.services.user.client.ClientService;
import br.com.socialmeli.services.user.seller.SellerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SellerFollowServiceImpl implements SellerFollowService {

    private final SellerFollowRepository sellerFollowRepository;

    private final SellerService<Seller> sellerService;

    private final ClientService<Client> clientService;

    public SellerFollowServiceImpl(SellerFollowRepository sellerFollowRepository, SellerService<Seller> sellerService, ClientService<Client> clientService) {
        this.sellerFollowRepository = sellerFollowRepository;
        this.sellerService = sellerService;
        this.clientService = clientService;
    }

    @Override
    public void followSeller(Long clientId, Long sellerId) {
        if (clientId.equals(sellerId))
            throw new UserCantFollowHimSelfException(null);
        ClientDTO clientDTO = clientService.findById(clientId).orElseThrow(() -> new ClientNotFoundException(null));
        SellerDTO sellerDTO = sellerService.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));

        Optional<SellerFollow> followOp = sellerFollowRepository.findById(new SellerFollowKey(clientId, sellerId));
        if (followOp.isPresent()) throw new ClientAlreadyFollowSellerException(null);

        SellerFollow sellerFollow = SellerFollowMapper.buildSellerFollow(sellerDTO, clientDTO);

        sellerFollowRepository.save(sellerFollow);
    }

    @Override
    public void unfollowSeller(Long clientId, Long sellerId) {
        clientService.findById(clientId).orElseThrow(() -> new ClientNotFoundException(null));
        sellerService.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));
        SellerFollow sellerFollow = sellerFollowRepository.findById(new SellerFollowKey(clientId, sellerId))
                .orElseThrow(() -> new UserNotFollowSellerException(null));
        sellerFollowRepository.delete(sellerFollow);
    }

    @Override
    public List<Long> sellersIdFollowedByClient(Long clientId) {
        return sellerFollowRepository.findSellerIdByClientId(clientId);
    }

    // SELLER
    public SellerFollowersDTO sellerFollowers(Long sellerId) {
        return sellerFollowers(sellerId, null);
    }

    public SellerFollowersDTO sellerFollowers(Long sellerId, SortParam sortParam) {
        SellerDTO sellerDTO = sellerService.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));
        List<Client> followers = sellerFollowRepository.findClientFollowingBySellerId(sellerId, SortService.build(sortParam, "client."));
        return SellerFollowMapper.buildSellerFollowersDTO(sellerDTO, followers);
    }

    // END SELLER

    // CLIENT
    @Override
    public ClientFollowedDTO clientFollowed(Long clientId) {
        return clientFollowed(clientId, null);
    }

    @Override
    public ClientFollowedDTO clientFollowed(Long clientId, SortParam sortParam) {
        ClientDTO clientDTO = clientService.findById(clientId).orElseThrow(() -> new ClientNotFoundException(null));
        List<Seller> followed = sellerFollowRepository.findSellerFollowingBySellerId(clientId, SortService.build(sortParam, "seller."));
        return SellerFollowMapper.buildClientFollowedDTO(clientDTO, followed);
    }
    // END CLIENT
}
