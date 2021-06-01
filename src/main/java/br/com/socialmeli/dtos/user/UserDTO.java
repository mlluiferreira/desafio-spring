package br.com.socialmeli.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"userId", "userName"})
public class UserDTO {
    @JsonProperty(value = "userId")
    public Long id = 0L;

    @JsonProperty("userName")
    public String name;

    public UserDTO() { }

    public UserDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
