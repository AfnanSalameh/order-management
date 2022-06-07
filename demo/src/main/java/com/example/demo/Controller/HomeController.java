package com.example.demo.Controller;

import com.example.demo.Dto.CustomerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public CustomerDto home() {
        return new CustomerDto("Afnan", "1181469");
    }
}