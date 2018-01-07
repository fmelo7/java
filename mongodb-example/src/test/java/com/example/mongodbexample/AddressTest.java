package com.example.mongodbexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void canCreateAddress() {

        Address address = new Address(5, "5th avenue", "new york", "new york");

        Address created = repository.save(address);

        assertThat(created).isNotNull();
        assertThat(created.getId()).isNotEmpty();
    }

    @Test(expected = ConstraintViolationException.class)
    public void cannotCreateAddressWithNullValues() {

        Address address = new Address();

        Address created = repository.save(address);
    }

    @Test
    public void canCreateAddressWithCustomer() {

        Customer customer = new Customer("john", "doe");
        Customer createdCustomer = customerRepository.save(customer);

        Address address = new Address(5, "5th avenue", "new york", "new york");
        address.setCustomer(customer);
        Address created = repository.save(address);

        assertThat(created).isNotNull();
        assertThat(created.getId()).isNotEmpty();
        assertThat(created.getCustomer()).isNotNull();
        assertThat(created.getCustomer().getId()).isNotEmpty();
        assertThat(created.getCustomer().getFirstname()).isEqualTo("john");
    }
}