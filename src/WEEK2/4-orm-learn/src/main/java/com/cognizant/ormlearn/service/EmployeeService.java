package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * EmployeeService (Doc 2 / Hands-on 4 and Doc 3 / Hands-on 2, 4, 5, 6).
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Doc 2 / Hands-on 4
    @Transactional
    public Employee get(int id) {
        return employeeRepository.findById(id).get();
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    // Doc 3 / Hands-on 2
    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    // Doc 3 / Hands-on 4
    @Transactional
    public double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    @Transactional
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    // Doc 3 / Hands-on 5
    @Transactional
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }

    // Doc 3 / Hands-on 6
    @Transactional
    public List<Employee> searchEmployees(String name, Integer departmentId,
                                          Boolean permanent, Double minSalary) {
        return employeeRepository.searchEmployees(name, departmentId, permanent, minSalary);
    }
}
