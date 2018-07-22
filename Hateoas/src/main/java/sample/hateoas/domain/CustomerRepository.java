package sample.hateoas.domain;

import java.util.List;

/**
 * Created by CBR on 2018. 7. 22..
 */
public interface CustomerRepository
{
    List<Customer> findAll();
    Customer findOne(Long id);
}
