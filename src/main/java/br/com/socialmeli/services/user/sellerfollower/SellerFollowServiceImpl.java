package br.com.socialmeli.services.user.sellerfollower;

import br.com.socialmeli.controllers.SortParam;
import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.SellerFollow;
import br.com.socialmeli.entities.users.SellerFollowKey;
import br.com.socialmeli.exceptions.user.ClientNotFoundException;
import br.com.socialmeli.exceptions.user.SellerNotFoundException;
import br.com.socialmeli.exceptions.user.UserNotFollowSeller;
import br.com.socialmeli.repositories.user.SellerFollowRepository;
import br.com.socialmeli.services.SortService;
import br.com.socialmeli.services.user.client.ClientService;
import br.com.socialmeli.services.user.seller.SellerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public void followSeler(Long clientId, Long sellerId) {
        clientService.findById(clientId).orElseThrow(() -> new ClientNotFoundException(null));
        sellerService.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));

        SellerFollow sellerFollow = new SellerFollow();

        Seller seller = new Seller();
        seller.setId(sellerId);
        sellerFollow.setSeller(seller);

        Client client = new Client();
        client.setId(clientId);
        sellerFollow.setClient(client);

        sellerFollowRepository.save(sellerFollow);
    }

    @Override
    public void unfollowSeller(Long clientId, Long sellerId) {
        clientService.findById(clientId).orElseThrow(() -> new ClientNotFoundException(null));
        sellerService.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));
        SellerFollow sellerFollow = sellerFollowRepository.findById(new SellerFollowKey(clientId, sellerId))
                .orElseThrow(() -> new UserNotFollowSeller(null));
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
        return getSellerFollowersDTO(sellerDTO, followers);
    }

    private SellerFollowersDTO getSellerFollowersDTO(SellerDTO sellerDTO, List<Client> followers) {
        Set<ClientDTO> followersDTO = followers.stream()
                .map(client -> new ClientDTO(client.getId(), client.getName()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO();
        BeanUtils.copyProperties(sellerDTO, sellerFollowersDTO);
        sellerFollowersDTO.setFollowers(followersDTO);

        return sellerFollowersDTO;
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
        return getClientFollowedDTO(clientDTO, followed);
    }

    private ClientFollowedDTO getClientFollowedDTO(ClientDTO clientDTO, List<Seller> followed) {
        Set<SellerDTO> followedDTO = followed.stream()
                .map(seller -> new SellerDTO(seller.getId(), seller.getName()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        ClientFollowedDTO clientFollowedDTO = new ClientFollowedDTO();
        BeanUtils.copyProperties(clientDTO, clientFollowedDTO);
        clientFollowedDTO.setFollowed(followedDTO);

        return clientFollowedDTO;
    }
    // END CLIENT
}
