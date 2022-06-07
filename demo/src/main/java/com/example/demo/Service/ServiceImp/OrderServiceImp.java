package com.example.demo.Service.ServiceImp;

import com.example.demo.Entity.Order;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.OrderService;
import com.example.demo.exception.ResourceNotFoundException;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public abstract class OrderServiceImp extends OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImp(ProductRepository productRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public @NotNull Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }




    @Override
    public Order getOrder(int id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));    }



    @Override
    public Order save(Order order) {

        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        return null;
    }

    @Override
    public Order update(int id, Order orderDTO) {
        Optional<Order> order = orderRepository.findById(id);
        order.get().setId(orderDTO.getId());

        Order result = orderRepository.save(order.get());
        //todo you should use mappers to spperate the DTO and entities usage.
        return result;
    }



}
