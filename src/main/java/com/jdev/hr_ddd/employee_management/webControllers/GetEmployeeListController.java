package com.jdev.hr_ddd.employee_management.webControllers;

import com.jdev.hr_ddd.employee_management.domain.models.Employee;
import com.jdev.hr_ddd.employee_management.useCases.GetEmployeeListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetEmployeeListController {
    private final GetEmployeeListUseCase getEmployeeListUseCase;

    @Autowired
    public GetEmployeeListController(GetEmployeeListUseCase getEmployeeListUseCase) {

        this.getEmployeeListUseCase = getEmployeeListUseCase;
    }

    @PostMapping("api/employee/list")
    public ResponseEntity<Response> GetList(@RequestBody Request request) {
        List<Employee> list = getEmployeeListUseCase.execute();

        int page = request.page();
        int size = request.size();
        int totalCount = list.size();

        int startingIndex = (page - 1) * size;
        int endingIndex = Math.min(startingIndex + size, totalCount); // min value to prevent out of bound error

        String[] filteredBy = request.filteredBy() != null ? request.filteredBy() : new String[]{};

        List<Employee> paginatedList = list.subList(startingIndex, endingIndex);

        return ResponseEntity.ok(new Response(page, size, totalCount, filteredBy, paginatedList));
    }

    public record Request(
        int page,
        int size,
        String[] filteredBy

    ) {
        // overload constructor to define the default values
        // instead of using @RequestParam.
        public Request() {
            this(1, 10, new String[]{});
        }
    }

    public record Response(
        int page,
        int size,
        int totalCount,
        String[] filteredBy,
        List<Employee> list
    ) {}

}
