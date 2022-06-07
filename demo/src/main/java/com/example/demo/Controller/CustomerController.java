package com.example.demo.Controller;


import com.example.demo.Dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @GetMapping(value = "/customer")
    public CustomerDto getSCustomer() {
        return new CustomerDto("Afnan", "Salameh");
    }

    @GetMapping(value = "/customer")
    public List<CustomerDto> getSCustomers() {
        List<CustomerDto> customerList = new ArrayList<CustomerDto>();
        for (int i = 0; i < 5; i++) {
            customerList.add(new CustomerDto("name" + i, "lastname" + i));
        }
        return customerList;
    }

    @GetMapping(value = "/customer/V2")
    public ResponseEntity<CustomerDto> getSCustomerV2() {
        return ResponseEntity.ok(new CustomerDto("Mohammed", "Ahmad"));
    }

    //path variable,  uri template variable   {firstname}/{lastName}
    //in order ot bind value of URI template variable to method parameter, we use @PathVariable
    @GetMapping(value = "/customer/{firstName}/{lastName}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return ResponseEntity.ok(new CustomerDto(firstName, lastName));
    }

    //build rest API to handle query params
    ///student?firstName=mohammad
    @GetMapping(value = "/customerRequestParam")
    public ResponseEntity<CustomerDto> getCustomerRequestParam(@RequestParam("firstName") String firstName,
                                                               @RequestParam(name = "lastName") String lastName) {
        return ResponseEntity.ok(new CustomerDto(firstName, lastName));
    }
//    @GetMapping(value = "/studentx")
//    public ResponseEntity<CustomerDto> getCustomerx(@RequestParam("firstName") String firstName,
//                                                            @RequestParam(name = "lastName") String lastName) {
//        return ResponseEntity.ok(new CustomerDto(firstName, lastName));
//    }
}
