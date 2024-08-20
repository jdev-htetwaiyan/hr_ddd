package com.jdev.hr_ddd.employee_management.domain.repositories;

import com.jdev.hr_ddd.employee_management.domain.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
