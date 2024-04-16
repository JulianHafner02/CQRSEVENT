package at.fhv.lab1.commandclient.repositories;

import at.fhv.lab1.commandclient.domainmodel.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository
public class CustomerRepository {

    private Set<Customer> customers = new HashSet<>();

    public void save(Customer customer) {
        customers.add(customer);
    }

    public boolean contains(Customer customer) {
        return customers.contains(customer);
    }

    public void delete(Customer customer) {
        customers.remove(customer);
    }

    public void deleteAll() {
        customers.clear();
    }

    public Set<Customer> findAll() {
        return new HashSet<>(customers);
    }

    public Customer findByCustomerName(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return customers.isEmpty();
    }

    public int count() {
        return customers.size();
    }
}
