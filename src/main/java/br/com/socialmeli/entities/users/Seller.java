package br.com.socialmeli.entities.users;

import br.com.socialmeli.entities.post.Post;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

import static br.com.socialmeli.entities.users.UserType.SELLER;

@Entity
public class Seller extends Client {

    public Seller() {
        this.type = SELLER;
    }

    @OneToMany(mappedBy = "seller")
    private Set<SellerFollow> followers;

    @OneToMany(mappedBy = "seller")
    private Set<Post> posts;

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<SellerFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<SellerFollow> followers) {
        this.followers = followers;
    }
}
