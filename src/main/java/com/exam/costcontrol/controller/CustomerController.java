package com.exam.costcontrol.controller;

import com.exam.costcontrol.entity.Customer;
import com.exam.costcontrol.exception.CustomerNotFoundException;
import com.exam.costcontrol.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public Iterable<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable(name = "id") int id){
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    @PostMapping("/newCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable(name = "id") int id){
        Customer delete= customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        customerRepository.delete(delete);
    }
    @PutMapping("{id}")
    public Customer updateCustomerById(@RequestBody Customer customer){
        Customer updateCustomer = customerRepository.findById(customer.getId()).orElseThrow(CustomerNotFoundException::new);
        customerRepository.save(updateCustomer);
        return updateCustomer;
    }





}
