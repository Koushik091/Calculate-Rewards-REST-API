package com.example.service.springbootrewards.rewards;

import com.example.service.springbootrewards.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RewardsControllerTest {

    @InjectMocks
    private RewardsController rewardsController;

    @Mock
    private RewardsService rewardsService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCustomers() {
        // Arrange
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Customer 1"));
        customers.add(new Customer(2, "Customer 2"));

        when(rewardsService.getCustomerAll()).thenReturn(customers);

        // Act
        List<Customer> result = rewardsController.getAllCustomers();

        // Assert
        assertEquals(customers, result);
    }

    @Test
    public void testGetCustomerById() {
        // Arrange
        Customer customer = new Customer(1, "Customer 1");

        when(rewardsService.getCustomerById(1)).thenReturn(customer);
        when(rewardsService.getCustomerById(2)).thenReturn(null);

        // Act
        ResponseEntity<Customer> response1 = rewardsController.getCustomerById(1);
        ResponseEntity<Customer> response2 = rewardsController.getCustomerById(2);

        // Assert
        assertEquals(HttpStatus.OK, response1.getStatusCode());
        assertEquals(customer, response1.getBody());

        assertEquals(HttpStatus.NOT_FOUND, response2.getStatusCode());
    }
}