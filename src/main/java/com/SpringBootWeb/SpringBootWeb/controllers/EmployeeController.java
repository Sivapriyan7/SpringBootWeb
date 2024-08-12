package com.SpringBootWeb.SpringBootWeb.controllers;


import com.SpringBootWeb.SpringBootWeb.dto.EmployeeDTO;
import com.SpringBootWeb.SpringBootWeb.entities.EmployeeEntity;
import com.SpringBootWeb.SpringBootWeb.repositories.EmployeeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage()
//    {
//        return "Secret message : Sivapriyan M";
//    }
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){

        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy)
    {
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee)
    {
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping String updateEmployeeById()
    {
        return "Hello from PUT";
    }

}
