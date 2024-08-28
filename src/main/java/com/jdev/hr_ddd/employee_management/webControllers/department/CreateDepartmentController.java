package com.jdev.hr_ddd.employee_management.webControllers.department;

import com.jdev.hr_ddd.employee_management.domain.models.Department;
import com.jdev.hr_ddd.employee_management.useCases.department.CreateDepartmentUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateDepartmentController {

    private final CreateDepartmentUseCase createDepartmentUsecase;

    public CreateDepartmentController(CreateDepartmentUseCase createDepartmentUsecase) {

        this.createDepartmentUsecase = createDepartmentUsecase;
    }

    @PostMapping("/api/department/create")
    public ResponseEntity<Response> createDepartment(@Valid @RequestBody Request request) {

        Department savedDepartment = createDepartmentUsecase.execute(request);
        return ResponseEntity.ok(new Response(savedDepartment.getId()));
    }

    public record Request(
        @NotBlank
        String name
    ) {}

    public record Response(
        long id
    ){}

}
