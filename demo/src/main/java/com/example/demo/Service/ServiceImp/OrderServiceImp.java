package com.example.demo.Service.ServiceImp;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Order;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Service.OrderService;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public abstract class OrderServiceImp implements  OrderService {

    private OrderRepository orderRepository;


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }





    public OrderDto updateOrder(OrderDto orderDto, int id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("order", "id", id));

        order.setId(orderDto.getId());
        order.setOrderedAt(orderDto.getOrderedAt());
        order.setCustomerId(orderDto.getCustomerId());


        Order updatedo = orderRepository.save(order);
        return mapToDTO(updatedo);
    }



    private OrderDto mapToDTO(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCustomerId(order.getCustomerId());
        orderDto.setOrderedAt(order.getOrderedAt());
               return orderDto;
    }

    private Order mapToEntity(OrderDto orderDto){
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrderedAt(orderDto.getOrderedAt());
        order.setCustomerId(orderDto.getCustomerId());
        return order;

    }


}
