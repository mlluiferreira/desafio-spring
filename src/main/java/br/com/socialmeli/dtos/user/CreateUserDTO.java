package br.com.socialmeli.dtos.user;

import br.com.socialmeli.entities.users.UserType;

public class CreateUserDTO {
    public String name;

    public UserType type;

    public CreateUserDTO() { }

    public CreateUserDTO(String name, UserType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
