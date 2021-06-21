package com.grupo4.sorteio.services;

import com.grupo4.sorteio.dtos.CreateUserDTO;
import com.grupo4.sorteio.dtos.UserDTO;
import com.grupo4.sorteio.entities.User;
import com.grupo4.sorteio.exceptions.UserNotFoundException;
import com.grupo4.sorteio.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO create(CreateUserDTO createUserDTO) {
        User user = new User();
        BeanUtils.copyProperties(createUserDTO, user);
        user = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public UserDTO findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found", null));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
