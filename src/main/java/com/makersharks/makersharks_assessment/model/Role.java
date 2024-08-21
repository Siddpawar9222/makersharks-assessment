package com.makersharks.makersharks_assessment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role_table")
@NoArgsConstructor
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Integer id ;


    @Column(name = "role_name")
    @Enumerated(EnumType.ORDINAL)
    private ERole name ;
}
