package com.grupo4.sorteio.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class UserPrize {

    @EmbeddedId
    private UserPrizeKey id = new UserPrizeKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "client_id")
    private User user;

    @ManyToOne
    @MapsId("prizeId")
    @JoinColumn(name = "prize_id")
    private Prize prize;

    public UserPrize() {
    }

    public UserPrize(UserPrizeKey id, User user, Prize prize) {
        this.id = id;
        this.user = user;
        this.prize = prize;
    }

    public UserPrizeKey getId() {
        return id;
    }

    public void setId(UserPrizeKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }
}
