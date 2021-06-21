package com.grupo4.sorteio.dtos;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class CreateUserDTO {

    @NotNull
    @Size(min = 2)
    private String name;

    public CreateUserDTO() {
    }

    public CreateUserDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
