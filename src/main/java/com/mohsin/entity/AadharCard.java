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
public class AadharCard {
    @Id
    private Long id;
    private String aadharNumber;
    private String address;

    @OneToOne(mappedBy = "aadharCard")
    private User user;

    @Override
    public String toString() {
        return "AadharCard{" +
                "id=" + id +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AadharCard that = (AadharCard) o;
        return Objects.equals(id, that.id) && Objects.equals(aadharNumber, that.aadharNumber) && Objects.equals(address, that.address) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aadharNumber, address, user);
    }
}
