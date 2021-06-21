package com.grupo4.sorteio.repositories;

import com.grupo4.sorteio.entities.UserPrize;
import com.grupo4.sorteio.entities.UserPrizeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrizeRepository extends JpaRepository<UserPrize, UserPrizeKey> {
}
