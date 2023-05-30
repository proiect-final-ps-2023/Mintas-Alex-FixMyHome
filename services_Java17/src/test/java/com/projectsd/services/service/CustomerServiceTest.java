package com.projectsd.services.service;

import com.projectsd.services.model.Customer;
import com.projectsd.services.repository.CustomerRepository;
import com.projectsd.services.service.implementation.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerService customerService;

/*    @Test
    public void getCustomersTest() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());

        given(customerRepository.findAll()).willReturn(customers);

        List<Customer> expected = customerService.getCustomers();

        assertEquals(expected, customers);
        verify(customerRepository).findAll();
    }*/

    @Test
    public void createCustomerTest() {
        Customer customer = new Customer();
        customer.setEmail("SteamAlex12@yahoo.ro");

        when(customerRepository.save(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        assertThat(createdCustomer.getEmail()).isSameAs(customer.getEmail());
        verify(customerRepository).save(customer);
    }

/*    @Test
    public void whenGivenId_shouldDeleteCustomer_ifFound() {
        Customer customer = new Customer();

        customer.setFirstName("Alex");
        customer.setId(1L);

        when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
        customerService.deleteCustomer(customer.getId());

        verify(customerRepository).deleteById(customer.getId());
    }*/

/*    @Test
    public void updateCustomerTest() {
        Customer customer = new Customer();
        customer.setId(89L);
        customer.setFirstName("Alex");

        Customer newCustomer = new Customer();
        newCustomer.setFirstName("Oana");
        newCustomer.setId(89L);

        given(customerRepository.findById(customer.getId())).willReturn(Optional.of(customer));

        customerService.updateCustomer(newCustomer);
        verify(customerRepository).save(newCustomer);
        verify(customerRepository).findById(customer.getId());
    }*/
}
