package br.com.socialmeli.services.user;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.UserDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.User;
import br.com.socialmeli.services.user.client.ClientService;
import br.com.socialmeli.services.user.seller.SellerService;
import br.com.socialmeli.services.user.sellerfollower.SellerFollowService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import static br.com.socialmeli.entities.users.UserType.CLIENT;
import static br.com.socialmeli.entities.users.UserType.SELLER;

@Service
public class UserServiceImpl implements UserService {
    private final ClientService<Client> clientService;

    private final SellerService<Seller> sellerService;

    private final SellerFollowService sellerFollowService;

    public UserServiceImpl(ClientService<Client> clientService, SellerService<Seller> sellerService, SellerFollowService sellerFollowService) {
        this.clientService = clientService;
        this.sellerService = sellerService;
        this.sellerFollowService = sellerFollowService;
    }

    // SELLER

    @Override
    public void followSeler(Long clientId, Long sellerId) { sellerFollowService.followSeler(clientId, sellerId); }

    @Override
    public SellerFollowersDTO sellerFollowers(Long sellerId) {
        return sellerService.sellerFollowers(sellerId);
    }

    @Override
    public SellerCountDTO counterSellerFollowers(Long sellerId) { return sellerService.counterSellerFollowers(sellerId); }

    // SELLER END

    // -----------------------------------------------------------------------------------------------------------------

    // CLIENT

    @Override
    public ClientFollowedDTO clientFollowed(Long clientId) {
        return clientService.clientFollowed(clientId);
    }

    // CLIENT END

    @Override
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
