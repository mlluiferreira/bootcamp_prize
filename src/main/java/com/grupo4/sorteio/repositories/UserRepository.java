package com.grupo4.sorteio.repositories;

import com.grupo4.sorteio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
