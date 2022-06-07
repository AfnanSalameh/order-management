package com.example.demo.Service.ServiceImp;

import com.example.demo.Dto.CustomerDto;
import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.CustomerService;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImp extends CustomerService {


    CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository){this.customerRepository = customerRepository;}

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapToDto(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(customer);
    }

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = mapToEntity(customerDto);
        Customer newCustomer = customerRepository.save(customer);
        return mapToDto(newCustomer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CustomerServiceImp.class.getName(),"id",id));
        customer.setId(customer.getId());
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());

        Customer updatedCustomer = customerRepository.save(customer);
        CustomerDto updatedCustomerDto = mapToDto(updatedCustomer);
        return updatedCustomerDto;
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CustomerServiceImp.class.getName(), "id", id));
        customerRepository.delete(customer);
    }

    private Customer mapToEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setId(customer.getId());
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());

        return customer;
    }
    private CustomerDto mapToDto(Customer customer){
        CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getFirstname(), customer.getLastname());
        return customerDto;
}
}