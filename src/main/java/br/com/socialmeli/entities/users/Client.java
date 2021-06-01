package br.com.socialmeli.entities.users;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

import static br.com.socialmeli.entities.users.UserType.CLIENT;

@Entity
public class Client extends User {

    public Client() {
        this.userType = CLIENT;
    }

    @OneToMany(mappedBy = "client")
    private Set<SellerFollow> followings;

    public Set<SellerFollow> getFollowings() {
        return followings;
    }

    public void setFollowings(Set<SellerFollow> followings) {
        this.followings = followings;
    }
}
