package com.ksmart_assessment.__04_2025.contract;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class EmployeeDTO {


    private String name;
    private String designation;
    private double salary;

    
    
}
