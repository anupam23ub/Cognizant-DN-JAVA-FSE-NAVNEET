package com.example.ems.service;

import com.example.ems.entity.Department;
import com.example.ems.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * DepartmentService - CRUD operations for departments (Exercise 4).
 */
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Long id, Department changes) {
        Department existing = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Department not found: " + id));
        existing.setName(changes.getName());
        return departmentRepository.save(existing);
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
