package com.example.mongodbexample;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableMongoAuditing
public class MongodbExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbExampleApplication.class, args);
    }

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            Address address = new Address(1, "5th avenue", "new york", "ny");
            Address createdAddress = addressRepository.save(address);

            Customer customer = new Customer("john", "doe");
            customer.getAddresses().add(createdAddress);
            Customer createdCustomer = customerRepository.save(customer);
        };
    }
}

// ok use mongo db
// ok use data rest
// ok use auditable entity
// ok use validations
// ok use profile to test embedded mongodb
// ok use relational by reference
// TODO use service on mongodb atlas or firebase
// TODO ...

@RepositoryRestResource
interface AddressRepository extends CrudRepository<Address, String> {
}

@RepositoryRestResource
interface CustomerRepository extends CrudRepository<Customer, String> {
}

@Document
class Address {

    @Id
    private String _id;

    @NotNull
    private Integer number;

    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date modifyed;

    @DBRef
    private Customer customer;

    public Address() {
    }

    public Address(Integer number, String street, String city, String state) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModifyed() {
        return modifyed;
    }

    public void setModifyed(Date modifyed) {
        this.modifyed = modifyed;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address{" +
                "_id='" + _id + '\'' +
                ", number=" + number +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", created=" + created +
                ", modifyed=" + modifyed +
                ", customer=" + customer +
                '}';
    }
}

@Document
class Customer {

    @Id
    private String _id;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date modifyed;

    @DBRef
    private List<Address> addresses = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModifyed() {
        return modifyed;
    }

    public void setModifyed(Date modifyed) {
        this.modifyed = modifyed;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "_id='" + _id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", created=" + created +
                ", modifyed=" + modifyed +
                ", addresses=" + addresses +
                '}';
    }
}