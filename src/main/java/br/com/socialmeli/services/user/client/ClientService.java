package br.com.socialmeli.services.user.client;

import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.services.user.base.BaseUserTypeService;

public interface ClientService<T extends Client> extends BaseUserTypeService<T> {
    ClientFollowedDTO clientFollowed(Long clientId);
}
