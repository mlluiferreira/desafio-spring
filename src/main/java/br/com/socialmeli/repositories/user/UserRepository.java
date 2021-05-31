package br.com.socialmeli.repositories.user;

import br.com.socialmeli.entities.users.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository<T extends User> extends PagingAndSortingRepository<T, Long> {
}
