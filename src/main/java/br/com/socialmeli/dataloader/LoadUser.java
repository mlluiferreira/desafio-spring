package br.com.socialmeli.dataloader;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.services.user.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static br.com.socialmeli.entities.users.UserType.CLIENT;
import static br.com.socialmeli.entities.users.UserType.SELLER;

@Component
public class LoadUser implements ApplicationRunner {

    private final UserService userService;

    public LoadUser(UserService userService) {
        this.userService = userService;
    }

    private void loadClient() {
        CreateUserDTO[] clients = new CreateUserDTO[]
                {
                        new CreateUserDTO("cliente-1", CLIENT), new CreateUserDTO("cliente-2", CLIENT),
                        new CreateUserDTO("cliente-3", CLIENT), new CreateUserDTO("cliente-4", CLIENT),
                        new CreateUserDTO("cliente-5", CLIENT),
                };
        save(clients);
    }

    private void loadSeller() {
        CreateUserDTO[] sellers = new CreateUserDTO[]
                {
                        new CreateUserDTO("seller-1", SELLER), new CreateUserDTO("seller-2", SELLER),
                        new CreateUserDTO("seller-3", SELLER), new CreateUserDTO("seller-4", SELLER),
                        new CreateUserDTO("seller-5", SELLER),
                };
        save(sellers);
    }

    private void save(CreateUserDTO[] createUserDTOS) {
        Arrays.stream(createUserDTOS).forEach(userService::save);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadClient();
        loadSeller();
    }
}
