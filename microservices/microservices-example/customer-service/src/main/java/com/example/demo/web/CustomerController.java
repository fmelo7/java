package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@Controller
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(customerService.getAll());
	}

	// TODO othes methods
}
