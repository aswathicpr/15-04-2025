package com.ksmart_assessment.__04_2025.service;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ksmart_assessment.__04_2025.contract.EmployeeDTO;
import com.ksmart_assessment.__04_2025.exception.EmployeeIdNotFound;
import com.ksmart_assessment.__04_2025.model.Employee;
import com.ksmart_assessment.__04_2025.repository.EmployeeRepo;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepo empRepo;
    private final ModelMapper mapper;

    public List<Employee> getEmployees() {
      return  empRepo.findAll();
               
    }

    public Employee addNewEmployee(EmployeeDTO empDTO) {
       return empRepo.save(mapper.map(empDTO, Employee.class));
       
    }

    public Employee getEmpById(Integer id) {
      Employee emp =  empRepo.findById(id).orElseThrow(() -> new EmployeeIdNotFound(id));

      return emp;
    }

    public Employee updateEmployee(Integer id, EmployeeDTO empDTO) {
       Employee emp = empRepo.findById(id).orElseThrow(()-> new EmployeeIdNotFound(id));
       mapper.map(empDTO, emp);
       return empRepo.save(emp);

    }

    public String deleteById(Integer id) {
        if(empRepo.existsById(id)){
            empRepo.deleteById(id);
            return "Employee deleted";
        }
        else throw new EmployeeIdNotFound(id);
                //return null;
    }

    public Page<Employee> getByPage(Integer page, Integer size,  String sort) {
     
        PageRequest pageable = PageRequest.of(page, size,  Sort.by(sort));
        return empRepo.findAll(pageable);
    }


    
}
