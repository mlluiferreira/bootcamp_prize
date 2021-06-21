package com.grupo4.sorteio.dtos;

import java.util.List;

public class UserPrizesDTO extends UserDTO {

    private List<PrizeDTO> prizes;

    public UserPrizesDTO() {
    }

    public UserPrizesDTO(Long id, String name, List<PrizeDTO> prizes) {
        super(id, name);
        this.prizes = prizes;
    }

    public List<PrizeDTO> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<PrizeDTO> prizes) {
        this.prizes = prizes;
    }
}
