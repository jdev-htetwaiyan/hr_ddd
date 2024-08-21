package com.jdev.hr_ddd.employee_management.domain.repositories;

import com.jdev.hr_ddd.employee_management.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

// working with database
// for custom functionalities beside CRUD methods which can get by extending Jpa
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    Set<Employee> findByDepartmentsId(Long departmentId);
//
//    Set<Employee> findByPositionsId(Long positionId);

}
