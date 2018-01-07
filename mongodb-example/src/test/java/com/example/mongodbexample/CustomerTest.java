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
public class CustomerTest {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void canCreateCustomer() {

        Customer customer = new Customer("john", "doe");

        Customer createdCustomer = repository.save(customer);

        assertThat(createdCustomer).isNotNull();
        assertThat(createdCustomer.getId()).isNotNull();

        assertThat(createdCustomer.getCreated()).isNotNull();
        assertThat(createdCustomer.getModifyed()).isNotNull();
    }

    @Test(expected = ConstraintViolationException.class)
    public void cannotCreateCustomerWithNullValues() {

        Customer customer = new Customer();

        Customer createdCustomer = repository.save(customer);
    }

    @Test(expected = ConstraintViolationException.class)
    public void cannotCreateCustomerWithFirstnameNullValue() {

        Customer customer = new Customer();
        customer.setLastname("doe");

        Customer createdCustomer = repository.save(customer);
    }

    @Test(expected = ConstraintViolationException.class)
    public void cannotCreateCustomerWithLastnameNullValue() {

        Customer customer = new Customer();
        customer.setFirstname("john");

        Customer createdCustomer = repository.save(customer);
    }

    @Test
    public void canCreateCustomerWithAddress() {

        Address address = new Address(1, "5th avenue", "new york", "ny");
        Address createdAddress = addressRepository.save(address);

        Customer customer = new Customer("john", "doe");
        customer.getAddresses().add(createdAddress);
        Customer createdCustomer = repository.save(customer);

        assertThat(createdCustomer).isNotNull();
        assertThat(createdCustomer.getId()).isNotEmpty();
        assertThat(createdCustomer.getAddresses()).isNotEmpty();
        assertThat(createdCustomer.getAddresses().get(0).getId()).isNotEmpty();
        assertThat(createdCustomer.getAddresses().get(0).getStreet()).isEqualTo("5th avenue");
    }
}