package WEEK1.DesignPatterns.exercise11;

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void printCustomerInfo(String id) {
        String info = repository.findCustomerById(id);
        System.out.println(info);
    }
}