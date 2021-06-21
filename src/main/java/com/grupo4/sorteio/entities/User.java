package com.grupo4.sorteio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<UserPrize> prizes;

    @OneToMany(mappedBy = "winner")
    private List<Prize> winPrizes;

    public User() {
    }

    public User(Long id, String name, List<UserPrize> prizes, List<Prize> winPrizes) {
        this.id = id;
        this.name = name;
        this.prizes = prizes;
        this.winPrizes = winPrizes;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<UserPrize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<UserPrize> prizes) {
        this.prizes = prizes;
    }

    public List<Prize> getWinPrizes() {
        return winPrizes;
    }

    public void setWinPrizes(List<Prize> winPrizes) {
        this.winPrizes = winPrizes;
    }
}
