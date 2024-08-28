package com.jdev.hr_ddd.employee_management.useCases.department;

import com.jdev.hr_ddd.employee_management.domain.models.Department;
import com.jdev.hr_ddd.employee_management.domain.repositories.DepartmentRepository;
import com.jdev.hr_ddd.employee_management.webControllers.department.CreateDepartmentController.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDepartmentUseCase {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public CreateDepartmentUseCase(DepartmentRepository departmentRepository) {

        this.departmentRepository = departmentRepository;
    }

    public Department execute(Request request) {
        Department department = new Department(
            request.name()
        );

        return departmentRepository.save(department);
    }

}
