package br.com.socialmeli.entities.users;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

import static br.com.socialmeli.entities.users.UserType.SELLER;

@Entity
public class Seller extends User {

    public Seller() {
        this.userType = SELLER;
    }

    @OneToMany(mappedBy = "seller")
    private Set<SellerFollow> followers;

    public Set<SellerFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<SellerFollow> followers) {
        this.followers = followers;
    }
}
