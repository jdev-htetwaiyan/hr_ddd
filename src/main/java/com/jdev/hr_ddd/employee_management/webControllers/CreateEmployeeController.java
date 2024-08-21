package com.jdev.hr_ddd.employee_management.webControllers;

import com.jdev.hr_ddd.employee_management.domain.models.Employee;
import com.jdev.hr_ddd.employee_management.domain.valueObjects.NrcNumber;
import com.jdev.hr_ddd.employee_management.enums.Enums;
import com.jdev.hr_ddd.employee_management.useCases.CreateEmployeeUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employee")
public class CreateEmployeeController {

    private final CreateEmployeeUseCase createEmployeeUseCase;

    @Autowired
    public CreateEmployeeController(CreateEmployeeUseCase createEmployeeUseCase) {

        this.createEmployeeUseCase = createEmployeeUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<Response> saveEmployee(@Valid @RequestBody Request request) {

        Employee savedEmployee = createEmployeeUseCase.createEmployee(request);

        return ResponseEntity.ok(new Response(savedEmployee.getId()));
    }

    // Record for request
    public record Request(
        @NotBlank(message = "Field cannot be empty and must be between 3 to 30 characters") @Size(min = 3, max = 30)
        String fullName,
        @NotNull
        Enums.NationalityType nationality,
        @Valid
        NrcNumber nrcNumber,
        @NotBlank @Email
        String email,
        @NotBlank
        String phoneNumber,
        @NotBlank
        String emergencyContactNumber,
        @NotBlank
        String currentAddress,
        @NotBlank
        String permanentAddress,
        long DOB,
        Enums.EmploymentStatus employmentStatus
    ) {}

    // Record for response
    public record Response(long id) {}

}
