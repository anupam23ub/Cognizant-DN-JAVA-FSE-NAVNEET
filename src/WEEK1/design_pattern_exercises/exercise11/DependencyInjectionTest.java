package WEEK1.design_pattern_exercises.exercise11;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.printCustomerInfo("CUST-992");
    }
}
