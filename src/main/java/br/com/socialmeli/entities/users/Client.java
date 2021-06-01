package br.com.socialmeli.entities.users;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

import static br.com.socialmeli.entities.users.UserType.CLIENT;

@Entity
public class Client extends User {

    public Client() {
        this.type = CLIENT;
    }

    @OneToMany(mappedBy = "client")
    private Set<SellerFollow> followed;

    public Set<SellerFollow> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<SellerFollow> followings) {
        this.followed = followings;
    }
}
