package com.internetshop.entity;

import com.internetshop.entity.security.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "price")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date recordDate;

    @Column(name = "nomenclature_id")
    private Long nomenclatureId;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nomenclature")
    private Nomenclature nomenclature;
}
