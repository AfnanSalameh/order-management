package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Data

public class ProductDto {

    private int id;
    private String slug;
    private String name;
    private String reference;
    private double Price;
    private boolean stockable;
    private double vat;
}
