package br.com.socialmeli.entities.users;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Client extends User {

    @OneToMany(mappedBy = "client")
    private Set<SellerFollow> followings;

    public Set<SellerFollow> getFollowings() {
        return followings;
    }

    public void setFollowings(Set<SellerFollow> followings) {
        this.followings = followings;
    }
}
