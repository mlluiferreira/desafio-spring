package br.com.socialmeli.services.user;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.entities.users.User;
import br.com.socialmeli.repositories.user.UserBaseRepository;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public abstract class BaseUserTypeService<T extends User> {
    private final UserBaseRepository<T> userRepository;

    private Class<T> clazz;

    public BaseUserTypeService(UserBaseRepository<T> userRepository, Class<T> clazz) {
        this.userRepository = userRepository;
        this.clazz = clazz;
    }

    private T getNewInstance() {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T save(CreateUserDTO createUserDTO) {
        T user = getNewInstance();
        BeanUtils.copyProperties(createUserDTO, user);
        return userRepository.save(user);
    }

    public Optional<T> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
