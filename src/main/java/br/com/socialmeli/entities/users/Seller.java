package br.com.socialmeli.entities.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Seller extends User {

    @OneToMany(mappedBy = "seller")
    private Set<SellerFollow> followers;

    public Set<SellerFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<SellerFollow> followers) {
        this.followers = followers;
    }
}
