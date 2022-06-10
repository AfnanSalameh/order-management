package com.example.demo.Repository;

import com.example.demo.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {

    @Query(value="SELECT s.quantity FROM `stock` s ,`product` p WHERE s.product_id=p.id and p.name = :PName",nativeQuery = true)
    List<Integer> findQuantityProductByName(String PName);

    @Query(value = "SELECT * FROM `stock` WHERE update_at = :dateUp",nativeQuery = true)
    Stock findStockCertainDate(String dateUp);
}
