package br.com.socialmeli.services.user.sellerfollower;

import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.SellerFollow;
import br.com.socialmeli.exceptions.user.ClientNotFoundException;
import br.com.socialmeli.exceptions.user.SellerNotFoundException;
import br.com.socialmeli.repositories.user.SellerFollowRepository;
import br.com.socialmeli.services.user.client.ClientService;
import br.com.socialmeli.services.user.seller.SellerService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Long countSellerFollowers(Long sellerId) {
        return sellerFollowRepository.countBySellerId(sellerId);
    }

    @Override
    public List<Long> sellersIdFollowedByClient(Long clientId) {
        return sellerFollowRepository.findSellerIdByClientId(clientId);
    }
}
