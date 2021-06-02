package br.com.socialmeli.controllers;

import br.com.socialmeli.dtos.user.client.ClientFollowedDTO;
import br.com.socialmeli.dtos.user.seller.SellerCountDTO;
import br.com.socialmeli.dtos.user.seller.SellerFollowersDTO;
import br.com.socialmeli.services.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 0001
    @PostMapping("/{clientId}/follow/{sellerId}")
    public ResponseEntity<?> followSeller(@PathVariable Long clientId, @PathVariable Long sellerId) {
        userService.followSeler(clientId, sellerId);
        return ResponseEntity.ok().build();
    }

    // 0002
    @GetMapping("/{sellerId}/followers/count")
    public ResponseEntity<SellerCountDTO> countSellerFollowers(@PathVariable Long sellerId) {
        return ResponseEntity.ok(userService.counterSellerFollowers(sellerId));
    }

    // 0003
    @GetMapping("/{sellerId}/followers/list")
    public ResponseEntity<SellerFollowersDTO> sellerFollowers(@PathVariable Long sellerId, SortParam sort) {
        return ResponseEntity.ok(userService.sellerFollowers(sellerId, sort));
    }

    // 0004 0008
    @GetMapping("/{clientId}/followed/list")
    public ResponseEntity<ClientFollowedDTO> clientFollowed(@PathVariable Long clientId, SortParam sort) {
        return ResponseEntity.ok(userService.clientFollowed(clientId, sort));
    }

    // 0007 0008
    @PostMapping("/{clientId}/unfolow/{sellerId}")
    public ResponseEntity<?> unfollowSeller(@PathVariable Long clientId, @PathVariable Long sellerId) {
        userService.unfollowSeller(clientId, sellerId);
        return ResponseEntity.ok().build();
    }
}
