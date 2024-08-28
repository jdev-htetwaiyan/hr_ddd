package com.jdev.hr_ddd.employee_management.useCases.jobPosition;

import com.jdev.hr_ddd.employee_management.domain.models.JobPosition;
import com.jdev.hr_ddd.employee_management.domain.repositories.JobPositionRepository;
import com.jdev.hr_ddd.employee_management.webControllers.jobPosition.CreateJobPositionController.Request;
import org.springframework.stereotype.Service;

@Service
public class CreateJobPositionUseCase {

    public final JobPositionRepository jobPositionRepository;

    public CreateJobPositionUseCase(JobPositionRepository jobPositionRepository) {

        this.jobPositionRepository = jobPositionRepository;
    }

    public JobPosition execute(Request request) {
        JobPosition position = new JobPosition(request.title());

        return jobPositionRepository.save(position);
    }

}
