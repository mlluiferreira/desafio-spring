package br.com.socialmeli.services.user.client;

import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.exceptions.user.ClientNotFoundException;
import br.com.socialmeli.repositories.user.ClientRepository;
import br.com.socialmeli.services.user.base.BaseUserTypeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
class ClientServiceImpl extends BaseUserTypeServiceImpl<Client> implements ClientService<Client> {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        super(clientRepository, Client.class);
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientFollowedDTO clientFollowed(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(null));

        Set<SellerDTO> sellers = client.getFollowed().stream().map(followed -> {
            Seller seller = followed.getSeller();
            return new SellerDTO(seller.getId(), seller.getName());
        }).collect(Collectors.toSet());

        ClientFollowedDTO clientFollowedDTO = new ClientFollowedDTO();
        BeanUtils.copyProperties(client, clientFollowedDTO);
        clientFollowedDTO.setFollowed(sellers);

        return clientFollowedDTO;
    }
}
