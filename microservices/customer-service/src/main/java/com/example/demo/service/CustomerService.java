package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;

@Service
public class CustomerService {

	private static final List<Customer> db = new ArrayList<>();

	public void save(Customer customer) {
		db.add(customer);
	}

	public void delete(Customer customer) {
		db.remove(customer);
	}

	public List<Customer> getAll() {
		return db;
	}

	public void getById(String id) {
		db.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
	}
}
