package com.mohsin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PanCard {

    @Id
    private Long id;
    private String panNumber;

    @OneToOne(mappedBy = "panCard")
    private User user;

    @Override
    public String
    toString() {
        return "PanCard{" +
                "id=" + id +
                ", panNumber='" + panNumber + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PanCard panCard = (PanCard) o;
        return Objects.equals(id, panCard.id) && Objects.equals(panNumber, panCard.panNumber) && Objects.equals(user, panCard.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, panNumber, user);
    }
}
