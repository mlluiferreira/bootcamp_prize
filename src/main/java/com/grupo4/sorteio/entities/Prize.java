package com.grupo4.sorteio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Entity
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(nullable = false)
    private BigDecimal award;

    @OneToMany(mappedBy = "prize")
    private List<UserPrize> users;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User winner;

    public Prize() {
    }

    public Prize(Long id, String name, BigDecimal award, List<UserPrize> users, User winner) {
        this.id = id;
        this.name = name;
        this.award = award;
        this.users = users;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAward() {
        return award;
    }

    public void setAward(BigDecimal award) {
        this.award = award;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserPrize> getUsers() {
        return users;
    }

    public void setUsers(List<UserPrize> users) {
        this.users = users;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    @JsonIgnore
    public User draw() {
        List<User> users = getUsers().stream().map(UserPrize::getUser).collect(Collectors.toList());
        int index = new Random().nextInt(users.size());
        winner = users.get(index);
        return winner;
    }
}
