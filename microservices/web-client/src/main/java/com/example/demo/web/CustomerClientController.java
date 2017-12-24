package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CustomerWebService;
import com.example.demo.vo.Customer;

@Controller
@RequestMapping("customers")
public class CustomerClientController {

	@Autowired
	private CustomerWebService customerWebService;

	@GetMapping
	private ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(customerWebService.getAll());
	}

	// TODO others methods
}
