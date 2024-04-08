package at.fhv.lab1.queryclient.repositories;

import at.fhv.lab1.queryclient.projectedmodel.ProjectedCustomer;

import java.util.HashSet;
import java.util.Set;

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
