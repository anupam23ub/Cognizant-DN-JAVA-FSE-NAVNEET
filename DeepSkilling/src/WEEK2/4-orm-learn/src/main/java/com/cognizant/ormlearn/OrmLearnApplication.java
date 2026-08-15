package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * orm-learn - cumulative driver for all three Spring Data JPA hands-on
 * documents (com.cognizant.ormlearn).
 *
 * Per the assignment, the services are held in static references assigned from
 * the application context inside main(), and each hands-on has a dedicated
 * test method. Uncomment the one you want to run and comment the rest, exactly
 * as the documents instruct ("Include testXxx() in main and comment the other
 * test method calls").
 */
@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockService stockService;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);
        stockService = context.getBean(StockService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        attemptService = context.getBean(AttemptService.class);

        // ---- Doc 1: Country CRUD ----
        testGetAllCountries();
        // testGetCountry();
        // testAddCountry();
        // testUpdateCountry();
        // testDeleteCountry();

        // ---- Doc 2 / Hands-on 1: Country query methods ----
        // testSearchCountries();
        // testSearchCountriesSorted();
        // testCountriesStartingWith();

        // ---- Doc 2 / Hands-on 2: Stock query methods ----
        // testFacebookSeptember2019();
        // testGoogleAbove1250();
        // testTop3ByVolume();
        // testNetflixLowest3();

        // ---- Doc 2 / Hands-on 4-6: relationships ----
        // testGetEmployee();
        // testAddEmployee();
        // testUpdateEmployee();
        // testGetDepartment();
        // testAddSkillToEmployee();

        // ---- Doc 3: HQL / native / criteria / quiz ----
        // testGetAllPermanentEmployees();
        // testAverageSalary();
        // testNativeQuery();
        // testCriteriaQuery();
        // testQuizAttempt();
    }

    // =====================================================================
    // Doc 1 - Country CRUD
    // =====================================================================

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries:{}", countries.size());
        countries.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End");
    }

    private static void testGetCountry() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country lookup failed", e);
        }
        LOGGER.info("End");
    }

    private static void testAddCountry() {
        LOGGER.info("Start");
        Country country = new Country();
        country.setCode("XX");
        country.setName("Xanadu");
        countryService.addCountry(country);
        LOGGER.debug("Added:{}", country);
        LOGGER.info("End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start");
        try {
            countryService.updateCountry("XX", "Xanadu Republic");
            LOGGER.debug("Updated:{}", countryService.findCountryByCode("XX"));
        } catch (CountryNotFoundException e) {
            LOGGER.error("Update failed", e);
        }
        LOGGER.info("End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("XX");
        LOGGER.debug("Deleted country XX");
        LOGGER.info("End");
    }

    // =====================================================================
    // Doc 2 / Hands-on 1 - Country query methods
    // =====================================================================

    private static void testSearchCountries() {
        LOGGER.info("Start");
        LOGGER.debug("Contains 'ou':{}", countryService.searchCountries("ou"));
        LOGGER.info("End");
    }

    private static void testSearchCountriesSorted() {
        LOGGER.info("Start");
        LOGGER.debug("Contains 'ou' sorted:{}", countryService.searchCountriesSorted("ou"));
        LOGGER.info("End");
    }

    private static void testCountriesStartingWith() {
        LOGGER.info("Start");
        LOGGER.debug("Starting with 'Z':{}", countryService.findCountriesStartingWith("Z"));
        LOGGER.info("End");
    }

    // =====================================================================
    // Doc 2 / Hands-on 2 - Stock query methods
    // =====================================================================

    private static Date parse(String yyyyMmDd) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(yyyyMmDd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void testFacebookSeptember2019() {
        LOGGER.info("Start");
        List<?> result = stockService.getStocksByCodeAndDateRange(
                "FB", parse("2019-09-01"), parse("2019-09-30"));
        result.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    private static void testGoogleAbove1250() {
        LOGGER.info("Start");
        stockService.getStocksAbovePrice("GOOGL", 1250.0)
                .forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    private static void testTop3ByVolume() {
        LOGGER.info("Start");
        stockService.getTop3ByVolume().forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    private static void testNetflixLowest3() {
        LOGGER.info("Start");
        stockService.getLowest3ByClose("NFLX").forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    // =====================================================================
    // Doc 2 / Hands-on 4-6 - relationships
    // =====================================================================

    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.debug("Skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setName("New Joiner");
        employee.setSalary(500000);
        employee.setPermanent(true);
        employee.setDateOfBirth(parse("1995-01-01"));
        Department department = departmentService.get(1);
        employee.setDepartment(department);
        employeeService.save(employee);
        LOGGER.debug("Saved employee:{}", employee);
        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        Department department = departmentService.get(2);
        employee.setDepartment(department);
        employeeService.save(employee);
        LOGGER.debug("Updated employee:{}", employee);
        LOGGER.info("End");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start");
        Department department = departmentService.get(3);
        LOGGER.debug("Department:{}", department);
        LOGGER.debug("Employees:{}", department.getEmployeeList());
        LOGGER.info("End");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");
        // employee 1 and skill 4 (SQL) have no relationship in the seed data
        Employee employee = employeeService.get(1);
        Skill skill = skillService.get(4);
        employee.getSkillList().add(skill);
        employeeService.save(employee);
        LOGGER.debug("Skills after add:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    // =====================================================================
    // Doc 3 - HQL / aggregate / native / criteria / quiz
    // =====================================================================

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

    private static void testAverageSalary() {
        LOGGER.info("Start");
        LOGGER.debug("Average salary (all):{}", employeeService.getAverageSalary());
        LOGGER.debug("Average salary (dept 3):{}", employeeService.getAverageSalary(3));
        LOGGER.info("End");
    }

    private static void testNativeQuery() {
        LOGGER.info("Start");
        employeeService.getAllEmployeesNative().forEach(e -> LOGGER.debug("{}", e));
        LOGGER.info("End");
    }

    private static void testCriteriaQuery() {
        LOGGER.info("Start");
        // dynamic filter: permanent engineers (dept 3) earning at least 800000
        List<Employee> result =
                employeeService.searchEmployees(null, 3, Boolean.TRUE, 800000.0);
        result.forEach(e -> LOGGER.debug("{}", e));
        LOGGER.info("End");
    }

    private static void testQuizAttempt() {
        LOGGER.info("Start");
        Attempt attempt = attemptService.getAttempt(1, 1);
        LOGGER.debug("User: {}", attempt.getUser().getName());
        LOGGER.debug("Attempted Date: {}", attempt.getDate());
        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            LOGGER.debug("{}", aq.getQuestion().getText());
            int index = 1;
            for (AttemptOption ao : aq.getAttemptOptions()) {
                LOGGER.debug(" {}) {}    {}    {}",
                        index++,
                        ao.getOption().getText(),
                        ao.getOption().isCorrect() ? aq.getQuestion().getScore() : 0.0,
                        ao.isSelected());
            }
        }
        LOGGER.info("End");
    }
}
