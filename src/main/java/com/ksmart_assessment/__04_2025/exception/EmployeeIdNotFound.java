package com.ksmart_assessment.__04_2025.exception;

public class EmployeeIdNotFound extends RuntimeException {

    public EmployeeIdNotFound(Integer id){
        super("Employee with id " +id +"  not found ");
                    
            }
        
                       

}
