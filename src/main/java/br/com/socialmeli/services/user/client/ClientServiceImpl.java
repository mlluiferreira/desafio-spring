package br.com.socialmeli.services.user.client;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.exceptions.user.ClientNotFoundException;
import br.com.socialmeli.repositories.user.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class ClientServiceImpl implements ClientService<Client> {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
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

    @Override
    public Optional<ClientDTO> findById(Long sellerId) {
        Client client = clientRepository.findById(sellerId).orElse(null);
        if (client == null) return Optional.empty();
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return Optional.of(clientDTO);
    }

    @Override
    public ClientDTO save(CreateUserDTO createUserDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(createUserDTO, client);
        client = clientRepository.save(client);
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }
}
