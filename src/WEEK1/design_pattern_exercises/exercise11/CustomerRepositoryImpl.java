package WEEK1.design_pattern_exercises.exercise11;

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        return "Customer Data for ID: " + id;
    }
}
