package com.grupo4.sorteio.dtos;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class CreatePrizeDTO {

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Min(value = 1)
    private BigDecimal award;

    public CreatePrizeDTO() {
    }

    public CreatePrizeDTO(@Size(min = 2) String name, @Min(value = 1) BigDecimal award) {
        this.name = name;
        this.award = award;
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
}
