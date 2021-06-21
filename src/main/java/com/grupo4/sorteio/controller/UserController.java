package com.grupo4.sorteio.controller;

import com.grupo4.sorteio.dtos.CreateUserDTO;
import com.grupo4.sorteio.dtos.UserDTO;
import com.grupo4.sorteio.services.UserPrizeService;
import com.grupo4.sorteio.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final UserPrizeService userPrizeService;

    public UserController(UserService userService, UserPrizeService userPrizeService) {
        this.userService = userService;
        this.userPrizeService = userPrizeService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return ResponseEntity.ok(userService.create(createUserDTO));
    }

    @PostMapping("/{userId}/prize/{prizeId}")
    public ResponseEntity<?> addToPrize(@PathVariable Long userId, @PathVariable Long prizeId) {
        userPrizeService.addUserToPrize(userId, prizeId);
        return ResponseEntity.ok().build();
    }
}
