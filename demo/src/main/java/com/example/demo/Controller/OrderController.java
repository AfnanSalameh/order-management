package com.example.demo.Controller;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;
import com.example.demo.exception.BadRequestException;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

public class OrderController {



    private final Logger log = LoggerFactory.getLogger(OrderController.class);


    @Autowired
    private OrderService order_service;
    public OrderController(OrderService order_service) {

        this.order_service = order_service;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return order_service.getAllOrders(); //ResponseEntity represents an HTTP response, including headers, body, and status.
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(order_service.getOrderById(id));
    }



    @GetMapping("/date/{date}")
    public List<OrderDto> findOrderCertainDate(@PathVariable(name = "date") String date) throws ParseException {
        return order_service.findOrderCertainDate(date);
    }

    @PostMapping
    public ResponseEntity<OrderDto> insertOrder(@Valid @RequestBody OrderDto order_Dto) {
        return new ResponseEntity<>(order_service.insertOrder(order_Dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@Valid @RequestBody OrderDto order_Dto
            , @PathVariable(name = "id") int id) {

        return new ResponseEntity<>(order_service.updateOrder(order_Dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name = "id") int id) {
        order_service.deleteOrderById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

}
