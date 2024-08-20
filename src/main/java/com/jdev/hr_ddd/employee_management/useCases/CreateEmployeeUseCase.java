package com.jdev.hr_ddd.employee_management.useCases;

import com.jdev.hr_ddd.employee_management.domain.models.Employee;
import com.jdev.hr_ddd.employee_management.domain.repositories.EmployeeRepository;
import com.jdev.hr_ddd.employee_management.interfaces.CreateEmployeeController.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// to handle user actions
@Service
public class CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public CreateEmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    Too many fields. Will use mapper here later
    public Employee createEmployee(Request request) {

        Employee employee = new Employee(
            request.fullName(),
            request.nationality(),
            request.NRC(),
            request.email(),
            request.phoneNumber(),
            request.emergencyContactNumber(),
            request.currentAddress(),
            request.permanentAddress(),
            request.DOB(),
            request.employmentStatus()
        );

        return employeeRepository.save(employee);
    }
}
