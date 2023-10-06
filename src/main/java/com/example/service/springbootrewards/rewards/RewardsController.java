package com.example.service.springbootrewards.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.service.springbootrewards.model.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return rewardsService.getCustomerAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = rewardsService.getCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}