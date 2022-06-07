package com.example.demo.Entity;

import javax.persistence.*;

public class Product_order {

    @Column(name="price", nullable = false)
    private double price;

    private double vat;

    //order_id is foreign key to id in order table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;

    //product_id is foreign key to id in table product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;



}
