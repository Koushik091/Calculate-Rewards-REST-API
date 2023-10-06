package com.example.service.springbootrewards.rewards;

import com.example.service.springbootrewards.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RewardsServiceTest {

    @InjectMocks
    private RewardsService rewardsService;

    @Mock
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomerAll() {
        // Arrange
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Customer 1"));
        customers.add(new Customer(2, "Customer 2"));

        when(customerRepository.findAll()).thenReturn(customers);

        // Act
        List<Customer> result = rewardsService.getCustomerAll();

        // Assert
        assertEquals(customers, result);
    }

    @Test
    public void testGetCustomerById() {
        // Arrange
        Customer customer = new Customer(1, "Customer 1");

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        when(customerRepository.findById(2)).thenReturn(Optional.empty());

        // Act
        Customer result1 = rewardsService.getCustomerById(1);
        Customer result2 = rewardsService.getCustomerById(2);

        // Assert
        assertEquals(customer, result1);
        assertNull(result2);
    }
}