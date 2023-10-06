package com.example.service.springbootrewards.rewards;

import com.example.service.springbootrewards.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        // Insert sample data for testing
        Customer customer1 = new Customer(1, "Customer 1");
        Customer customer2 = new Customer(2, "Customer 2");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }

    @Test
    public void testFindAll() {
        List<Customer> customers = customerRepository.findAll();
        assertNotNull(customers);
        assertEquals(3, customers.size());
    }

    @Test
    public void testFindById() {
        Optional<Customer> optionalCustomer = customerRepository.findById(1);
        assertTrue(optionalCustomer.isPresent());

        Customer customer = optionalCustomer.get();
        assertEquals(1, customer.getId().intValue());
        assertEquals("Customer 1", customer.getName());
    }

    @Test
    public void testFindByIdNotFound() {
        Optional<Customer> optionalCustomer = customerRepository.findById(100);
        assertFalse(optionalCustomer.isPresent());
    }
}


