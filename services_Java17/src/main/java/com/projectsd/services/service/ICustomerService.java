package com.projectsd.services.service;

import com.projectsd.services.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface ICustomerService {
    Customer createCustomer(Customer customer);

    Collection<Customer> getCustomers(int limit);

    Customer findCustomerById(Long id);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);

}
