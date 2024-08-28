package com.jdev.hr_ddd.employee_management.webControllers;

import com.jdev.hr_ddd.employee_management.domain.models.Employee;
import com.jdev.hr_ddd.employee_management.enums.Enums;
import com.jdev.hr_ddd.employee_management.useCases.CreateEmployeeUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CreateEmployeeController {

    private final CreateEmployeeUseCase createEmployeeUseCase;

    @Autowired
    public CreateEmployeeController(CreateEmployeeUseCase createEmployeeUseCase) {

        this.createEmployeeUseCase = createEmployeeUseCase;
    }

    @PostMapping("/api/employee/create")
    public ResponseEntity<Response> saveEmployee(@Valid @ModelAttribute Request request, @RequestPart("photoPath")
                                                 MultipartFile photoPath) {

        Employee savedEmployee = createEmployeeUseCase.createEmployee(request, photoPath);

        return ResponseEntity.ok(new Response(savedEmployee.getId()));
    }

    public record Request(
        @NotBlank(message = "Field cannot be empty and must be between 3 to 30 characters") @Size(min = 3, max = 30)
        String fullName,
        @NotNull
        Enums.NationalityType nationality,
        @NotBlank
        String idNumber,
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

    public record Response(long id) {}

}
