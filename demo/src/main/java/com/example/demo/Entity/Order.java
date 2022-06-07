package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int customerId;
    private Date orderedAt;



    @ManyToOne(fetch = FetchType.LAZY)
    //fetch lazy -> fetch related entity from database
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    //relation between product order and product is one to many
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Product_order> productOrderSet= new HashSet<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
