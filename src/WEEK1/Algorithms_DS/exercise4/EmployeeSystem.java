package WEEK1.Algorithms_DS.exercise4;

class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

class EmployeeSystem {
    private Employee[] employees;
    private int count;

    public EmployeeSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
        }
    }

    public Employee searchEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].name);
        }
    }

    public void deleteEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                break;
            }
        }
    }
}
