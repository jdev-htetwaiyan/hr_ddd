package com.jdev.hr_ddd.employee_management.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Getter
@Setter
@Table(name = "tb_position")
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String title;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedPosition")
    private Set<Employee> employeeSet = new HashSet<>();
}