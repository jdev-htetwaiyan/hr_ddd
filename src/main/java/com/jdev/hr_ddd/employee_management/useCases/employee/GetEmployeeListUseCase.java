package com.jdev.hr_ddd.employee_management.useCases.employee;

import com.jdev.hr_ddd.employee_management.domain.models.Employee;
import com.jdev.hr_ddd.employee_management.domain.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEmployeeListUseCase {

    private  final EmployeeRepository employeeRepository;

    @Autowired
    public GetEmployeeListUseCase(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<Employee> execute() {

        return employeeRepository.findAll();
    }


}
