package br.com.socialmeli;

import br.com.socialmeli.dtos.user.CreateUserDTO;
import br.com.socialmeli.entities.users.UserType;
import br.com.socialmeli.services.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SocialmeliApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialmeliApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService) {
        return (args) -> {
            CreateUserDTO client = new CreateUserDTO("cliente", UserType.CLIENT);
            CreateUserDTO seller = new CreateUserDTO("vendedor", UserType.SELLER);
            CreateUserDTO teste = new CreateUserDTO("clienteTeste", UserType.CLIENT);
            userService.save(client);
            userService.save(seller);
            userService.save(teste);
        };
    }
}
