package com.jdev.hr_ddd.employee_management.interfaces;

import com.jdev.hr_ddd.employee_management.domain.models.Employee;
import com.jdev.hr_ddd.employee_management.useCases.CreateEmployeeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("api/employee")
public class CreateEmployeeController {

    private final CreateEmployeeUseCase createEmployeeUseCase;

    @Autowired
    public CreateEmployeeController(CreateEmployeeUseCase createEmployeeUseCase) {

        this.createEmployeeUseCase = createEmployeeUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<Response> saveEmployee(@RequestBody Request request) {
        Employee savedEmployee = createEmployeeUseCase.createEmployee(request);

        return ResponseEntity.ok(new Response(savedEmployee.getId()));
    }

    // Record for request
    public record Request(
        String fullName,
        String nationality,
        String NRC,
        String email,
        String phoneNumber,
        String emergencyContactNumber,
        String currentAddress,
        String permanentAddress,
        int DOB,
        boolean employmentStatus
    ) {}

    // Record for response
    public record Response(long id) {}

}
