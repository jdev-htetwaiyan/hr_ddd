package com.jdev.hr_ddd.employee_management.domain.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final String fullName;
    private final String nationality;
    private final String NRC;
    private final String email;
    private final String phoneNumber;
    private final String emergencyContactNumber;
    private final String currentAddress;
    private final String permanentAddress;
    private final int DOB;
    private final boolean employmentStatus;
//
//    @ManyToMany
//    @JoinTable(name = "tb_employee_position", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "position_id"))
//    private Set<JobPosition> assignedPosition = new HashSet<>();
//
//    @ManyToMany
//    @JoinTable(name = "tb_employee_department", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "department_id"))
//    private Set<Department> assignedDepartment = new HashSet<>();

}
