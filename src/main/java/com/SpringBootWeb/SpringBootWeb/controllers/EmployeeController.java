package com.SpringBootWeb.SpringBootWeb.controllers;


import com.SpringBootWeb.SpringBootWeb.dto.EmployeeDTO;
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

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){

        return new EmployeeDTO(id, "Siva","siva@gmail.com",23, LocalDate.of(2024,1,2),true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy)
    {
        return "Hi age "+ age+ sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee)
    {
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping String updateEmployeeById()
    {
        return "Hello from PUT";
    }

}
