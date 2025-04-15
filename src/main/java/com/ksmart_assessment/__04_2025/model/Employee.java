package com.ksmart_assessment.__04_2025.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee")
    @SequenceGenerator(sequenceName = "seq", name = "employee",  allocationSize = 1)

    private Integer id;
    private String name;
    private String designation;
    private double salary;

    
}
