package com.example.mongodbexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    private Customer savedCustomer;

    @Before
    public void setUp() throws Exception {
        repository.deleteAll();
        savedCustomer = repository.save(new Customer("paul", "smith"));
        repository.save(new Customer("ringo", "star"));
        repository.save(new Customer("simon", "garf"));
        repository.save(new Customer("peter", "framp"));
    }

    @Test
    public void shouldReturnRepositoryIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.customers").exists());
    }

    @Test
    public void canCreateCustomer() throws Exception {
        Customer newCustomer = new Customer("john", "doe");
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(newCustomer)))
                .andExpect(status().is(201));
    }

    @Test
    public void canRetrieveAllCustomers() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.customers", hasSize(4)))
                .andExpect(jsonPath("$._embedded.customers[0].firstname", is(savedCustomer.getFirstname())));
    }

    @Test
    public void canRetrieveOneCustomer() throws Exception {
        mockMvc.perform(get("/customers/{id}", savedCustomer.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id", is(savedCustomer.getId())))
                .andExpect(jsonPath("$.firstname", is(savedCustomer.getFirstname())));
    }

    @Test
    public void canUpdateCustomer() throws Exception {
        savedCustomer.setFirstname("john");
        mockMvc.perform(put("/customers/{id}", savedCustomer.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(savedCustomer)))
                .andExpect(status().is(204));
    }

    @Test
    public void canDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/customers/{id}", savedCustomer.getId()))
                .andExpect(status().is(204));
    }
}