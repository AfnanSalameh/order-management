package com.example.demo.Repository;

import com.example.demo.Entity.Product_order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public class product_orderRepository {

    @Repository
    public interface ProductOrderRepository extends JpaRepository<Product_order, Integer> {
        @Query(value="SELECT po.price FROM product_order po, `order` o where po.order_id=o.id and o.customer_id= :id",nativeQuery = true)
        List<Double> findTotalPriceOfAllOrdersByCustomerId(int id);



    }
}
