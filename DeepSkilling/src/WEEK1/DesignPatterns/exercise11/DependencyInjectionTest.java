package WEEK1.DesignPatterns.exercise11;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.printCustomerInfo("CUST-992");
    }
}
