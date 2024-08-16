package com.SpringBootWeb.SpringBootWeb.services;


import com.SpringBootWeb.SpringBootWeb.entities.EmployeeEntity;
import com.SpringBootWeb.SpringBootWeb.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }
}
