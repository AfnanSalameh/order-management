package com.example.demo.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "firstname",nullable = false)
    private String firstname;
    private String lastname;
    private Date bornAt;

/*the relation between customer and order
 is one to many
 */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Order> o= new HashSet<>();

    public Set<Role> getRoles() {

        return null;
    }
}
