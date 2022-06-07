package com.example.demo.Service;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Dto.StockDto;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.Stock;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public abstract class StockService {

    public abstract Stock getStock(int id);

    public abstract @NotNull Iterable<Stock> getAllStocks();

    public abstract StockDto getStockById(int id);

    public abstract StockDto addStock(StockDto StockDto);

    public static StockDto updateStock(StockDto StockDto, int id) {
        return null;
    }

    public abstract void deleteStock(int id);


    public abstract Stock save(Stock stock);

    public abstract Stock update(Long id, Stock stock);

    public abstract Stock update(int id, Stock stockDTO);

    public abstract Stock createStock(StockDto stockDto);

    public void deleteStockById(long id) {
    }
}
