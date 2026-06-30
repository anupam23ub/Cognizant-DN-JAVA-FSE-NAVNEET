package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeDto;
import com.example.ems.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * EmployeeController.
 *
 * Exercise 4: RESTful CRUD for employees.
 * Exercise 5: search endpoint backed by a query method.
 * Exercise 6: paged + sorted listing endpoint.
 * Exercise 8: DTO projection endpoint.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> all() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> one(@PathVariable Long id) {
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id,
                                           @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ---- Exercise 5: search ----
    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) {
        return employeeService.searchByName(name);
    }

    // ---- Exercise 6: pagination + sorting ----
    // e.g. GET /api/employees/paged?page=0&size=5&sortBy=name&direction=asc
    @GetMapping("/paged")
    public Page<Employee> paged(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size,
                                @RequestParam(defaultValue = "id") String sortBy,
                                @RequestParam(defaultValue = "asc") String direction) {
        return employeeService.findPaged(page, size, sortBy, direction);
    }

    // ---- Exercise 8: projection ----
    @GetMapping("/dto")
    public List<EmployeeDto> dtos() {
        return employeeService.findAllAsDto();
    }
}
