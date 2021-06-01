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

@Service
class SellerFollowServiceImpl implements SellerFollowService {

    private final SellerService<Seller> sellerService;

    private final ClientService<Client> clientService;

    private final SellerFollowRepository sellerFollowRepository;

    public SellerFollowServiceImpl(SellerService<Seller> sellerService, ClientService<Client> clientService, SellerFollowRepository sellerFollowRepository) {
        this.sellerService = sellerService;
        this.clientService = clientService;
        this.sellerFollowRepository = sellerFollowRepository;
    }

    private SellerFollow follow(Client client, Seller seller) {
        SellerFollow sellerFollow = new SellerFollow();
        sellerFollow.setSeller(seller);
        sellerFollow.setClient(client);
        return sellerFollowRepository.save(sellerFollow);
    }

    @Override
    public void followSeler(Long clientId, Long sellerId) {
        Client client = clientService.findById(clientId).orElseThrow(() -> new ClientNotFoundException(null));
        Seller seller = sellerService.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));
        follow(client, seller);
    }
    @Override
    public Long countSellerFollowers(Long sellerId) {
        return sellerFollowRepository.countBySellerId(sellerId);
    }
}
