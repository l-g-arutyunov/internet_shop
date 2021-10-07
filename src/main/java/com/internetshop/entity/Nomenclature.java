package com.internetshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "nomenclature")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nomenclature {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_of_nomenclature")
    @Enumerated(EnumType.STRING)
    private TypeOfNomenclature typeOfNomenclature;
}
