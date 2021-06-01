package br.com.socialmeli.repositories.user;

import br.com.socialmeli.entities.users.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends PagingAndSortingRepository<T, Long> {
}
