package com.makersharks.makersharks_assessment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "manufacturer_table")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int supplierId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "website")
    private String website;
    @Column(name = "location")
    private String location;
    @Column(name = "nature_of_business")
    private String natureOfBusiness;
    @Column(name = "manufacturing_processes")
    private String manufacturingProcesses;
}
