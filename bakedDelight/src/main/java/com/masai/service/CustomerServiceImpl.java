package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository cDao;

    @Override
    public Customer addCustomer(Customer customer){
        

        return cDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerException {
        
        
        cDao.findById(customer.getUserId()).orElseThrow(()->new CustomerException("Customer Not Found..."));

        return cDao.save(customer);
    }

    @Override
    public Customer deleteCustomer(Integer customerId) throws CustomerException {
        

        Customer customer = cDao.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not Found..."));

        cDao.delete(customer);

        return customer;
    }

    @Override
    public Customer getCustomer(Integer customerId) throws CustomerException {
        
        Customer customer = cDao.findById(customerId).orElseThrow(()-> new CustomerException("Customer Not Found..."));

        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() throws CustomerException {
        
        List<Customer> customers = cDao.findAll();

        if(customers.size()==0) throw new CustomerException("Customers Not found...");

        return customers;
    }
    
}