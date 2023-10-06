package com.example.service.springbootrewards.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.springbootrewards.model.Customer;

import java.util.List;

@Service
public class RewardsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomerAll() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(Integer customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}
}