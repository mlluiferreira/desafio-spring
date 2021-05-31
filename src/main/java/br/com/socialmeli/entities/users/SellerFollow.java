package br.com.socialmeli.entities.users;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class SellerFollow {

    @EmbeddedId
    private SellerFollowKey id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @MapsId("sellerId")
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public SellerFollow() { }

    public SellerFollow(SellerFollowKey id, Client client, Seller seller) {
        this.id = id;
        this.client = client;
        this.seller = seller;
    }

    public SellerFollowKey getId() {
        return id;
    }

    public void setId(SellerFollowKey id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
