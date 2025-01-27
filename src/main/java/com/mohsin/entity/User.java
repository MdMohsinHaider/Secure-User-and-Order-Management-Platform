package com.mohsin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pan_card_id", referencedColumnName = "id")
    private PanCard panCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhar_card_id", referencedColumnName = "id")
    private AadharCard aadharCard;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @Override
    public String

    toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", panCard=" + panCard +
                ", aadharCard=" + aadharCard +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(panCard, user.panCard) && Objects.equals(aadharCard, user.aadharCard) && Objects.equals(orders, user.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, panCard, aadharCard, orders);
    }
}
