package com.projectsd.services.service.implementation;

import com.projectsd.services.model.Customer;
import com.projectsd.services.model.Validator;
import com.projectsd.services.repository.CustomerRepository;
import com.projectsd.services.service.ICustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private Validator validator = new Validator();

    @Override
    public Customer createCustomer(Customer customer) {
        log.info("Saving new customer: {}", customer.getEmail());
        validator.validateUser(customer);
        return customerRepository.save(customer);
    }

    @Override
    public Collection<Customer> getCustomers(int limit) {
        log.info("Fetching all customers");
        return customerRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Customer findCustomerById(Long id) {
        log.info("Fetching customer by id: {}", id);
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        log.info("Updating customer: {}", customer.getEmail());
        validator.validateUser(customer);
        customer.setAge();
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        log.info("Deleting customer by ID: {}", id);
        customerRepository.deleteById(id);
    }
}
