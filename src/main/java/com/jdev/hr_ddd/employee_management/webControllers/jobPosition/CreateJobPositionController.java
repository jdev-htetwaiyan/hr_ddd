package com.jdev.hr_ddd.employee_management.webControllers.jobPosition;

import com.jdev.hr_ddd.employee_management.domain.models.JobPosition;
import com.jdev.hr_ddd.employee_management.useCases.jobPosition.CreateJobPositionUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateJobPositionController {

    public final CreateJobPositionUseCase createJobPositionUseCase;

    @Autowired
    public CreateJobPositionController(CreateJobPositionUseCase createJobPositionUseCase) {

        this.createJobPositionUseCase = createJobPositionUseCase;
    }

    @PostMapping("api/position/create")
    public ResponseEntity<Response> createPosition(@Valid @RequestBody Request request) {

        JobPosition position = createJobPositionUseCase.execute(request);

        return ResponseEntity.ok(new Response(position.getId()));
    }

    public record Request(
        @NotBlank
        String title
    ) {}

    public record Response(
        long id
    ) {}

}
