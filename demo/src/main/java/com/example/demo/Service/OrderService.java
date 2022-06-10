package com.example.demo.Service;
import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Order;
import org.springframework.stereotype.Service;
 import java.util.List;

@Service
public interface OrderService {
    OrderDto insertOrder(OrderDto order_Dto);

    List<OrderDto> findOrderCertainDate(String date);
    List<Order> getAllOrders();

    OrderDto getOrderById(int id);

    OrderDto updateOrder(OrderDto order_Dto, int id);

    void deleteOrderById(int id);
}