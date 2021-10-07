package com.internetshop.entity.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "userroles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolesDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "roleid")
    private Long roleId;

//    @ManyToOne
//    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
//    private User user;
}
