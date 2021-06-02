package br.com.socialmeli.services.user.client;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.entities.users.Client;

import java.util.Optional;

public interface ClientService<T extends Client>  {
    ClientFollowedDTO clientFollowed(Long clientId);

    Optional<ClientDTO> findById(Long clientId);

    ClientDTO save(CreateUserDTO createUserDTO);
}
