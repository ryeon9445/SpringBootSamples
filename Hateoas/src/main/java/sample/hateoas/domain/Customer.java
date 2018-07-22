package sample.hateoas.domain;

/**
 * Created by CBR on 2018. 7. 22..
 */

public class Customer
{
    private final Long id;
    private final String firstName;
    private final String lastName;

    public Customer(Long id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
}
