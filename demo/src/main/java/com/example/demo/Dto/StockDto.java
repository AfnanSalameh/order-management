package com.example.demo.Dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

public class StockDto {


    private int id;

    private Date updateAt;

    private int quantity;

    public StockDto(String id, String date, String quantity) {
    }
}
