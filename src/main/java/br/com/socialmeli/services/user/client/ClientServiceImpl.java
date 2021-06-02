package br.com.socialmeli.services.user.client;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.repositories.user.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class ClientServiceImpl implements ClientService<Client> {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private ClientDTO getClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    @Override
    public Optional<ClientDTO> findById(Long sellerId) {
        Client client = clientRepository.findById(sellerId).orElse(null);
        if (client == null) return Optional.empty();
        ClientDTO clientDTO = getClientDTO(client);
        return Optional.of(clientDTO);
    }

    @Override
    public ClientDTO save(CreateUserDTO createUserDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(createUserDTO, client);
        client = clientRepository.save(client);
        ClientDTO clientDTO = getClientDTO(client);
        return clientDTO;
    }
}
