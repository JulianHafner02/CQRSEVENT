package at.fhv.lab1.queryclient.repositories;

import at.fhv.lab1.eventbus.events.CustomerCreatedEvent;
import at.fhv.lab1.queryclient.projectedmodel.ProjectedCustomer;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProjectedCustomerRepository {

    private final Set<ProjectedCustomer> projectedCustomers = new HashSet<>();

    // Save method
    public void save(ProjectedCustomer customer) {
        projectedCustomers.add(customer);
    }

    // Contains method
    public boolean contains(ProjectedCustomer customer) {
        return projectedCustomers.contains(customer);
    }

    public ProjectedCustomer findByCustomerName(String customerName) {
        for (ProjectedCustomer customer : projectedCustomers) {
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    // Delete method
    public boolean delete(ProjectedCustomer customer) {
        return projectedCustomers.remove(customer);
    }

    // DeleteAll method
    public void deleteAll() {
        projectedCustomers.clear();
    }

    // FindAll method
    public Set<ProjectedCustomer> findAll() {
        return new HashSet<>(projectedCustomers);
    }

    // IsEmpty method
    public boolean isEmpty() {
        return projectedCustomers.isEmpty();
    }

    // Count method
    public int count() {
        return projectedCustomers.size();
    }

}
