package com.grupo4.sorteio.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PrizeDTO {
    private Long id;

    private String name;

    private BigDecimal award;

    private UserDTO winner;

    public PrizeDTO() {
    }

    public PrizeDTO(Long id, String name, BigDecimal award, UserDTO winner) {
        this.id = id;
        this.name = name;
        this.award = award;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAward() {
        return award;
    }

    public void setAward(BigDecimal award) {
        this.award = award;
    }

    public UserDTO getWinner() {
        return winner;
    }

    public void setWinner(UserDTO winner) {
        this.winner = winner;
    }
}
