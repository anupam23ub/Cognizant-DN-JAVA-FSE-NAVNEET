package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeDto;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EmployeeService.
 *
 * Exercise 4: CRUD operations.
 * Exercise 6: pagination + sorting helper.
 * Exercise 8: DTO projection passthrough.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ---- Exercise 4: CRUD ----
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee changes) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Employee not found: " + id));
        existing.setName(changes.getName());
        existing.setEmail(changes.getEmail());
        existing.setDepartment(changes.getDepartment());
        return employeeRepository.save(existing);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    // ---- Exercise 5: query methods ----
    public List<Employee> searchByName(String fragment) {
        return employeeRepository.findByNameContainingIgnoreCase(fragment);
    }

    // ---- Exercise 6: pagination + sorting combined ----
    public Page<Employee> findPaged(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }

    // ---- Exercise 8: DTO projection ----
    public List<EmployeeDto> findAllAsDto() {
        return employeeRepository.fetchAllAsDto();
    }
}
