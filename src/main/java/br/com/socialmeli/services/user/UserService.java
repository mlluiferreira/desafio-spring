package br.com.socialmeli.services.user;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.UserDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.User;
import br.com.socialmeli.exceptions.user.ClientNotFoundException;
import br.com.socialmeli.exceptions.user.SellerNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import static br.com.socialmeli.entities.users.UserType.CLIENT;
import static br.com.socialmeli.entities.users.UserType.SELLER;

@Service
public class UserService {
    private final ClientService clientService;

    private final SellerService sellerService;

    private final SellerFollowService sellerFollowService;

    public UserService(ClientService clientService, SellerService sellerService, SellerFollowService sellerFollowService) {
        this.clientService = clientService;
        this.sellerService = sellerService;
        this.sellerFollowService = sellerFollowService;
    }

    // SELLER

    public void followSeler(Long clientId, Long sellerId) {
        Client client = clientService.findById(clientId).orElseThrow(() -> new ClientNotFoundException(null));
        Seller seller = sellerService.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));
        sellerFollowService.follow(client, seller);
    }

    public SellerFollowersDTO sellerFollowers(Long sellerId) {
        return sellerService.sellerFollowers(sellerId);
    }

    public SellerCountDTO counterSellerFollowers(Long sellerId) {
        Seller seller = sellerService.findById(sellerId).orElseThrow(() -> new SellerNotFoundException(null));

        SellerCountDTO sellerCountDTO = new SellerCountDTO();
        BeanUtils.copyProperties(seller, sellerCountDTO);
        sellerCountDTO.setFollowers_count(sellerFollowService.countSellerFollowers(sellerId));

        return sellerCountDTO;
    }

    // SELLER END

    // -----------------------------------------------------------------------------------------------------------------

    // CLIENT

    public ClientFollowedDTO clientFollowed(Long clientId) {
        return clientService.clientFollowed(clientId);
    }

    // CLIENT END

    public UserDTO save(CreateUserDTO createUserDTO) {
        User user = new User();

        if (createUserDTO.getType() == SELLER)
            user = sellerService.save(createUserDTO);
        else if (createUserDTO.getType() == CLIENT)
            user = clientService.save(createUserDTO);

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);

        return userDTO;
    }
}
