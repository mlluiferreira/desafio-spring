package br.com.socialmeli.entities.users;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SellerFollowKey implements Serializable {
    @Column(name = "client_id")
    Long clientId;

    @Column(name = "seller_id")
    Long sellerId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SellerFollowKey)) return false;

        SellerFollowKey that = (SellerFollowKey) o;

        return new EqualsBuilder().append(clientId, that.clientId).append(sellerId, that.sellerId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(clientId).append(sellerId).toHashCode();
    }
}
