package com.example.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.vo.Customer;

@Service
public class CustomerWebService {

	private static final Logger LOGGER = Logger.getLogger(CustomerWebService.class.getName());

	private static final String CUSTOMER_SERVICE_URL = "http://CUSTOMER-SERVICE/customers";

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	public CustomerWebService() {
	}

	public List<Customer> getAll() {

		LOGGER.info("get all customers ");

		List<Customer> customers = Collections.emptyList();

		try {
			customers = Arrays.asList(restTemplate.getForObject(CUSTOMER_SERVICE_URL, Customer[].class));
		} catch (HttpClientErrorException e) {
			LOGGER.error("No customers found", e);
		}

		return customers;
	}
}
