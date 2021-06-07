package br.com.socialmeli.mapper.user;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.entities.users.Client;
import org.springframework.beans.BeanUtils;

public class ClientMapper {
    public static ClientDTO buildClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public static Client buildClient(CreateUserDTO createUserDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(createUserDTO, client);
        return client;
    }
}
