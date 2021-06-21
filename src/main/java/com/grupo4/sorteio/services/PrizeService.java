package com.grupo4.sorteio.services;

import com.grupo4.sorteio.dtos.CreatePrizeDTO;
import com.grupo4.sorteio.dtos.PrizeDTO;
import com.grupo4.sorteio.dtos.UserDTO;
import com.grupo4.sorteio.entities.Prize;
import com.grupo4.sorteio.exceptions.PrizeAlreadyDrawException;
import com.grupo4.sorteio.exceptions.PrizeNotFoundException;
import com.grupo4.sorteio.repositories.PrizeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PrizeService {
    private final PrizeRepository prizeRepository;

    public PrizeService(PrizeRepository prizeRepository) {
        this.prizeRepository = prizeRepository;
    }

    public PrizeDTO create(CreatePrizeDTO createPrizeDTO) {
        Prize prize = new Prize();
        BeanUtils.copyProperties(createPrizeDTO, prize);
        prize = prizeRepository.save(prize);
        PrizeDTO prizeDTO = new PrizeDTO();
        BeanUtils.copyProperties(prize, prizeDTO);
        return prizeDTO;
    }

    public PrizeDTO findById(Long prizeId) {
        Prize prize = prizeRepository.findById(prizeId).orElseThrow(() -> new PrizeNotFoundException("prize not found", null));
        PrizeDTO prizeDTO = new PrizeDTO();
        BeanUtils.copyProperties(prize, prizeDTO);
        return prizeDTO;
    }

    public PrizeDTO draw(Long prizeId) {
        Prize prize = prizeRepository.findById(prizeId).orElseThrow(() -> new PrizeNotFoundException("prize not found", null));

        if(prize.getWinner() != null) throw new PrizeAlreadyDrawException("prized already drawed", null);

        prize.draw();
        PrizeDTO prizeDTO = new PrizeDTO();
        prize = prizeRepository.save(prize);
        BeanUtils.copyProperties(prize, prizeDTO);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(prize.getWinner(), userDTO);
        prizeDTO.setWinner(userDTO);
        return prizeDTO;
    }
}
