package com.example.demo.Controller;

import com.example.demo.Entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class APIWrapperController {
    private final Logger log = LoggerFactory.getLogger(APIWrapperController.class);

    @Autowired
    //@Autowired annotation is used for dependency injection.In spring boot application, all loaded beans are eligible for auto wiring to another bean. The annotation @Autowired in spring boot is used to auto-wire a bean into another bean.
    @Qualifier(value = "restTemplate")
    RestTemplate restTemplate;

//    public APIWrapperController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @GetMapping("/api/user")
    public ResponseEntity<Customer[]> all(@RequestParam(value = "Afnna", defaultValue = "Salameh") String name) {
//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer[]> response =
                restTemplate.getForEntity(
                        "https://gorest.co.in/public/v2/customers",
                        Customer[].class);
        Customer[] customerList = response.getBody();
        return ResponseEntity.ok().body(customerList);
    }
}