package com.example.demo.Service;



import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Order;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public abstract class OrderService {

    public abstract Order getOrder(int id);

    public abstract @NotNull Iterable<Order> getAllOrders();

    public abstract OrderDto getOrderById(int id);

    public abstract OrderDto addOrder(OrderDto OrderDto);

    public abstract OrderDto updateOrder(OrderDto OrderDto, int id);

    public abstract void deleteCustomer(int id);

    public abstract Order save(Order order);

    public abstract Order update(Long id, Order order);

    public abstract Order update(int id, Order orderDTO);
}
