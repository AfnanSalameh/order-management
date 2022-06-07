package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String slug;
    private String name;
    private String reference;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "vat",nullable = false)
    private double vat;
    @Column(name = "stockable",nullable = false)
    private boolean stockable;

    //relation between product and product_order in one to many
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Product_order> productOrderSet=new HashSet<>();

    //relation between product and stock in one to many
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Stock> stockSet = new HashSet<>();


    public double getPrice(double price) {
        return price;
    }

    public double getVat(double vat) {
        return vat;
    }
}
