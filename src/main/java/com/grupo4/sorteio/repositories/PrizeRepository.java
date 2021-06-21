package com.grupo4.sorteio.repositories;

import com.grupo4.sorteio.entities.Prize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrizeRepository extends JpaRepository<Prize, Long> {
}
