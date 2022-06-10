package com.example.demo.Service;

import com.example.demo.Dto.StockDto;
import com.example.demo.Entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class StockService {

    public abstract Stock getStock(int id);

    public abstract StockDto insertStock(StockDto stock_Dto);

    public abstract List<Integer> findQuantityProductByName(String name);

    public abstract StockDto findStockCertainDate(String date);

    public abstract List<StockDto> getAllStocks();

    public abstract StockDto getStockById(int id);

    public abstract StockDto addStock(StockDto StockDto);


    public abstract void deleteStock(int id);


    public abstract Stock save(Stock stock);

    public abstract Stock update(Long id, Stock stock);

    public abstract Stock update(int id, Stock stockDTO);

    public abstract Stock createStock(StockDto stockDto);

    public void deleteStockById(long id) {
    }

    public abstract StockDto updateStock(StockDto stock_Dto, int id);

    public abstract void deleteStockById(int id);
}
