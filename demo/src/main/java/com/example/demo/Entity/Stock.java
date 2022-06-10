package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table

@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "updateAt",nullable = false)
    private Date updateAt;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    //product_id is foreign key to id in table product
    @ManyToOne(fetch=FetchType.LAZY)
     @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
}
