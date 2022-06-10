package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {


    private int id;

    private Date updateAt;

    private int quantity;

    public StockDto(String id, String date, String quantity) {
    }
}
