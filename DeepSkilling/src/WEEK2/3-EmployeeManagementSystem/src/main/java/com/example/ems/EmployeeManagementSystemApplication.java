package com.example.ems;

import com.example.ems.entity.Department;
import com.example.ems.entity.Employee;
import com.example.ems.repository.DepartmentRepository;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot entry point for the Employee Management System (Exercise 1).
 *
 * The CommandLineRunner seeds sample data and prints the results of the
 * pagination/sorting (Ex 6) and projection (Ex 8) features so they can be
 * observed in the console at startup, in addition to the REST endpoints.
 */
@SpringBootApplication
public class EmployeeManagementSystemApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeManagementSystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner seedAndDemo(DepartmentRepository departmentRepository,
                                  EmployeeRepository employeeRepository,
                                  EmployeeService employeeService) {
        return args -> {
            if (departmentRepository.count() > 0) {
                return; // already seeded
            }

            Department engineering = new Department("Engineering");
            Department finance = new Department("Finance");
            departmentRepository.save(engineering);
            departmentRepository.save(finance);

            Employee asha = new Employee("Asha Rao", "asha@example.com");
            asha.setDepartment(engineering);
            Employee vikram = new Employee("Vikram Singh", "vikram@example.com");
            vikram.setDepartment(engineering);
            Employee meera = new Employee("Meera Nair", "meera@example.com");
            meera.setDepartment(finance);
            employeeRepository.save(asha);
            employeeRepository.save(vikram);
            employeeRepository.save(meera);

            LOGGER.info("Seeded {} departments and {} employees",
                    departmentRepository.count(), employeeRepository.count());

            // Exercise 6 demo
            LOGGER.info("Page 0 (size 2, sorted by name asc): {}",
                    employeeService.findPaged(0, 2, "name", "asc").getContent());

            // Exercise 8 demo
            LOGGER.info("DTO projection: ");
            employeeService.findAllAsDto().forEach(d ->
                    LOGGER.info("  {} | {} | {}", d.getName(), d.getEmail(),
                            d.getDepartmentName()));
        };
    }
}
