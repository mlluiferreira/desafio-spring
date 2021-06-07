package br.com.socialmeli.mapper.user;

import br.com.socialmeli.dtos.user.client.ClientDTO;
import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.entities.users.Client;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.entities.users.SellerFollow;
import org.springframework.beans.BeanUtils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SellerFollowMapper {
    public static SellerFollow buildSellerFollow(SellerDTO sellerDTO, ClientDTO clientDTO) {
        SellerFollow sellerFollow = new SellerFollow();

        Seller seller = new Seller();
        seller.setId(sellerDTO.getId());
        sellerFollow.setSeller(seller);

        Client client = new Client();
        client.setId(clientDTO.getId());
        sellerFollow.setClient(client);

        return sellerFollow;
    }

    public static SellerFollowersDTO buildSellerFollowersDTO(SellerDTO sellerDTO, List<Client> followers) {
        Set<ClientDTO> followersDTO = followers.stream()
                .map(client -> new ClientDTO(client.getId(), client.getName()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO();
        BeanUtils.copyProperties(sellerDTO, sellerFollowersDTO);
        sellerFollowersDTO.setFollowers(followersDTO);

        return sellerFollowersDTO;
    }

    public static ClientFollowedDTO buildClientFollowedDTO(ClientDTO clientDTO, List<Seller> followed) {
        Set<SellerDTO> followedDTO = followed.stream()
                .map(seller -> new SellerDTO(seller.getId(), seller.getName()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        ClientFollowedDTO clientFollowedDTO = new ClientFollowedDTO();
        BeanUtils.copyProperties(clientDTO, clientFollowedDTO);
        clientFollowedDTO.setFollowed(followedDTO);

        return clientFollowedDTO;
    }
}
