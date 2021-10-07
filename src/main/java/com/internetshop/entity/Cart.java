package com.internetshop.entity;

import com.internetshop.entity.security.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "nomenclature_id")
    private Long nomenclatureId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "nomenclature", nullable = false)
    private Nomenclature nomenclature;
}
