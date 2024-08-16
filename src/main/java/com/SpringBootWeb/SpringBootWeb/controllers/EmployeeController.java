package com.SpringBootWeb.SpringBootWeb.controllers;


import com.SpringBootWeb.SpringBootWeb.dto.EmployeeDTO;
import com.SpringBootWeb.SpringBootWeb.entities.EmployeeEntity;
import com.SpringBootWeb.SpringBootWeb.repositories.EmployeeRepository;
import com.SpringBootWeb.SpringBootWeb.services.EmployeeService;
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
//    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){

        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy)
    {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee)
    {
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping String updateEmployeeById()
    {
        return "Hello from PUT";
    }

}
