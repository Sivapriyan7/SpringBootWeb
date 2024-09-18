package com.SpringBootWeb.SpringBootWeb.dto;

import com.SpringBootWeb.SpringBootWeb.annotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message =  "Name of the employee can't be empty")
    @Size(min = 3,max = 15, message = "Number of characters in name should be in range")
    private String name;

    @NotNull(message = "Email of the employee cannot be blank")
    @Email(message = "Enter a valid Email")
    private String email;

    @NotNull(message = "Age of the employee cannot be blank")
    @Max(value = 80, message = "Age can't be greater than 80")
    @Min(value = 18, message = "Age can't be lesser than 18")
    private Integer age;

    @NotBlank(message = "Role of the Employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of Employee can be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;


    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6,fraction = 2,message = "The salary can be in the form xxxxxx.yy")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in Future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;


}
