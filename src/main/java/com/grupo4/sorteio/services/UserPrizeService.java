package com.grupo4.sorteio.services;

import com.grupo4.sorteio.dtos.PrizeDTO;
import com.grupo4.sorteio.dtos.UserDTO;
import com.grupo4.sorteio.entities.Prize;
import com.grupo4.sorteio.entities.User;
import com.grupo4.sorteio.entities.UserPrize;
import com.grupo4.sorteio.entities.UserPrizeKey;
import com.grupo4.sorteio.exceptions.UserAlreadyOnPrizeException;
import com.grupo4.sorteio.repositories.UserPrizeRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPrizeService {
    private final UserPrizeRepository userPrizeRepository;

    private final UserService userService;

    private final PrizeService prizeService;

    public UserPrizeService(UserPrizeRepository userPrizeRepository, UserService userService, PrizeService prizeService) {
        this.userPrizeRepository = userPrizeRepository;
        this.userService = userService;
        this.prizeService = prizeService;
    }

    public void addUserToPrize(Long userId, Long prizeId) {
        UserDTO user = userService.findById(userId);
        PrizeDTO prize = prizeService.findById(prizeId);
        UserPrize userPrize = new UserPrize();
        UserPrizeKey userPrizeKey = new UserPrizeKey(userId, prizeId);

        if (userPrizeRepository.findById(userPrizeKey).isPresent()) throw new UserAlreadyOnPrizeException("user is on prize", null);

        userPrize.setPrize(new Prize(prizeId, null, null, null, null));
        userPrize.setUser(new User(userId, null, null, null));
        userPrizeRepository.save(userPrize);

    }
}
