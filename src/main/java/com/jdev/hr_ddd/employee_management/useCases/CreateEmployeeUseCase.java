package com.jdev.hr_ddd.employee_management.useCases;

import com.jdev.hr_ddd.employee_management.domain.models.Employee;
import com.jdev.hr_ddd.employee_management.domain.repositories.EmployeeRepository;
import com.jdev.hr_ddd.employee_management.webControllers.CreateEmployeeController.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

// to handle user actions
@Service
public class CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public CreateEmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    Too many fields. Will use mapper here later
    public Employee createEmployee(Request request, MultipartFile photoPath) {

        Employee employee = new Employee(
            request.fullName(),
            request.nationality(),
            request.idNumber(),
            request.email(),
            request.phoneNumber(),
            request.emergencyContactNumber(),
            request.currentAddress(),
            request.permanentAddress(),
            request.DOB(),
            request.employmentStatus()
        );

        // Handle the photo upload if a photo is provided
        if (photoPath != null && !photoPath.isEmpty()) {
            try {
                // Process file upload
                String fileName = StringUtils.cleanPath(Objects.requireNonNull(photoPath.getOriginalFilename()));
                String uploadDir = "employee-photos/"; // Create directories based on the employee later if needed
                Path uploadPath = Paths.get(uploadDir);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath); // Ensure the directory exists
                }

                Path filePath = uploadPath.resolve(fileName); // Resolve the file path

                // Check for file existence and throw exception
                if (Files.exists(filePath)) {
                    throw new IllegalStateException("File with the same name already exists: " + fileName);
                }

                Files.copy(photoPath.getInputStream(), filePath); // Copy the photo file to the file system

                // Set the file path in the employee entity
                employee.setPhotoPath(filePath.toString());
            } catch (IOException e) {
                throw new IllegalStateException("Failed to store the file. Please try again!", e);
            }
        }

        return employeeRepository.save(employee);
    }
}
