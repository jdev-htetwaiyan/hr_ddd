package com.jdev.hr_ddd.employee_management.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_department")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private final String name;

    @JsonIgnore // to prevent circular reference
    @ManyToMany(mappedBy = "assignedDepartment")
    private Set<Employee> employeeSet = new HashSet<>();

}