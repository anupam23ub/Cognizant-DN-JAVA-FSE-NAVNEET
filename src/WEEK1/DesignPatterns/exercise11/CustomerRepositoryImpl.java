package WEEK1.DesignPatterns.exercise11;

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        return "Customer Data for ID: " + id;
    }
}
