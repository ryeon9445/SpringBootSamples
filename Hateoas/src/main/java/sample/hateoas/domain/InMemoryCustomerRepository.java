package sample.hateoas.domain;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CBR on 2018. 7. 22..
 */

@Repository
public class InMemoryCustomerRepository implements CustomerRepository
{
    private final List<Customer> customers = new ArrayList<>();

    public InMemoryCustomerRepository()
    {
        this.customers.add(new Customer(1L, "Oliver", "Gierke"));
        this.customers.add(new Customer(2L, "Andy", "Wilkinson"));
        this.customers.add(new Customer(3L, "Dave", "Syer"));
    }

    @Override
    public List<Customer> findAll()
    {
        return this.customers;
    }

    @Override
    public Customer findOne(Long id)
    {
        for (Customer customer : this.customers)
        {
            if (ObjectUtils.nullSafeEquals(customer.getId(), id))
            {
                return customer;
            }
        }
        return null;
    }
}
