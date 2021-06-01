package br.com.socialmeli.services.user.base;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.entities.users.User;

import java.util.Optional;

public interface BaseUserTypeService<T extends User> {
    T save(CreateUserDTO createUserDTO);

    Optional<T> findById(Long userId);
}
