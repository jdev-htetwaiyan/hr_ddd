package com.jdev.hr_ddd.employee_management.domain.repositories;

import com.jdev.hr_ddd.employee_management.domain.models.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {
}
