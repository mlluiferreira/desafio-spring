package br.com.socialmeli.dtos.user.client;

import br.com.socialmeli.dtos.user.UserDTO;

public class ClientDTO extends UserDTO {
    public ClientDTO() {
    }

    public ClientDTO(Long id, String name) {
        super(id, name);
    }
}
