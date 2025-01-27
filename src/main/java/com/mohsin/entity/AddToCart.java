package com.mohsin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class AddToCart {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne
    private User user;

    @Override
    public String toString() {
        return "AddToCart{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddToCart addToCart = (AddToCart) o;
        return Objects.equals(id, addToCart.id) && Objects.equals(product, addToCart.product) && Objects.equals(user, addToCart.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, user);
    }
}
