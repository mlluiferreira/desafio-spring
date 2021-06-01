package br.com.socialmeli.dtos.user.seller;

import br.com.socialmeli.dtos.user.UserDTO;

public class SellerDTO extends UserDTO {
    public SellerDTO() {
    }

    public SellerDTO(Long id, String name) {
        super(id, name);
    }
}
