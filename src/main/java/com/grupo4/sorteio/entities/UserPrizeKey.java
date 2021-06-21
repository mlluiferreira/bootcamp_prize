package com.grupo4.sorteio.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserPrizeKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "prize_id")
    private Long prizeId;

    public UserPrizeKey() {
    }

    public UserPrizeKey(Long userId, Long prizeId) {
        this.userId = userId;
        this.prizeId = prizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof UserPrizeKey)) return false;

        UserPrizeKey that = (UserPrizeKey) o;

        return new org.apache.commons.lang.builder.EqualsBuilder().append(userId, that.userId).append(prizeId, that.prizeId).isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37).append(userId).append(prizeId).toHashCode();
    }
}
