package com.jdev.hr_ddd.employee_management.domain.models;
import com.jdev.hr_ddd.employee_management.domain.valueObjects.NrcNumber;
import com.jdev.hr_ddd.employee_management.enums.Enums;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private final Enums.NationalityType nationality;
    @Embedded
    @Column(unique = true)
    private final NrcNumber nrcNumber;
    @Column(unique = true)
    private final String email;
    @Column(unique = true)
    private final String phoneNumber;
    private final String emergencyContactNumber;
    private final String currentAddress;
    private final String permanentAddress;
    private final long DOB; // Epoch time stamp
    @Enumerated(EnumType.STRING)
    private final Enums.EmploymentStatus employmentStatus;
//
//    @ManyToMany
//    @JoinTable(name = "tb_employee_position", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "position_id"))
//    private Set<JobPosition> assignedPosition = new HashSet<>(); // set do not allow duplicate
//
//    @ManyToMany
//    @JoinTable(name = "tb_employee_department", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "department_id"))
//    private Set<Department> assignedDepartment = new HashSet<>();

}
