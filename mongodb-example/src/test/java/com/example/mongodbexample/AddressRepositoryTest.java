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
public class AddressRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private AddressRepository repository;

    private Address savedAddress;

    @Before
    public void setUp() throws Exception {
        repository.deleteAll();
        savedAddress = repository.save(new Address(1, "5th avenue", "new york", "NY"));
        repository.save(new Address(2, "riachuelo", "rio de janeiro", "rj"));
        repository.save(new Address(3, "2nd street", "tempe", "AZ"));
    }

    @Test
    public void shouldReturnRepositoryIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.addresses").exists());
    }

    @Test
    public void canCreateAddress() throws Exception {
        Address newAddress = new Address(123, "john kennedy", "virginia", "WA");
        mockMvc.perform(post("/addresses")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(newAddress)))
                .andExpect(status().is(201));
    }

    @Test
    public void canRetrieveAllAddresss() throws Exception {
        mockMvc.perform(get("/addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.addresses", hasSize(3)))
                .andExpect(jsonPath("$._embedded.addresses[0].street", is(savedAddress.getStreet())));
    }

    @Test
    public void canRetrieveOneAddress() throws Exception {
        mockMvc.perform(get("/addresses/{id}", savedAddress.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id", is(savedAddress.getId())))
                .andExpect(jsonPath("$.street", is(savedAddress.getStreet())));
    }

    @Test
    public void canUpdateAddress() throws Exception {
        savedAddress.setStreet("1st street");
        mockMvc.perform(put("/addresses/{id}", savedAddress.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(savedAddress)))
                .andExpect(status().is(204));
    }

    @Test
    public void canDeleteAddress() throws Exception {
        mockMvc.perform(delete("/addresses/{id}", savedAddress.getId()))
                .andExpect(status().is(204));
    }

}