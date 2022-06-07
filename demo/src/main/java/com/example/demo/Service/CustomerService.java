package com.example.demo.Service;

import com.example.demo.Dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CustomerService {

    public abstract List<CustomerDto> getAllCustomers();

    public abstract CustomerDto getCustomerById(int id);

    public abstract CustomerDto addCustomer(CustomerDto customerDto);

    public abstract CustomerDto updateCustomer(CustomerDto customerDto, int id);

    public abstract void deleteCustomer(int id);

}





