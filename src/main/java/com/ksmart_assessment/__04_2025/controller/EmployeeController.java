package com.ksmart_assessment.__04_2025.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ksmart_assessment.__04_2025.contract.EmployeeDTO;
import com.ksmart_assessment.__04_2025.model.Employee;
import com.ksmart_assessment.__04_2025.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@AllArgsConstructor
// @RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService empService;
    
    @GetMapping("/getemplyees")
    public List<Employee> getEmployees() {

        return empService.getEmployees();
    }
    
    @PostMapping("/addemp")
    public Employee addEmployee(@Valid @RequestBody EmployeeDTO empDTO) {
                
        return empService.addNewEmployee(empDTO);
    }
    @GetMapping("/getempbyid")
    public Employee getById(@RequestParam Integer id) {
        return empService.getEmpById(id);
    }
    
    @PutMapping("updateemp/{id}")
    public Employee updateEmp(@Valid @PathVariable Integer id, @Valid @RequestBody EmployeeDTO empDTO) {
               
        return empService.updateEmployee(id, empDTO);
    }

    @DeleteMapping("/deletebyid")
    public String deleteEmp(@RequestParam Integer id){
        return empService.deleteById(id);
    }
    
    @GetMapping("/pagination")
    public Page<Employee> getPagination(@RequestParam Integer page, @RequestParam Integer size,  @RequestParam String sort) {
       
       return empService.getByPage( page,size, sort);

        

    }
    
    
}
