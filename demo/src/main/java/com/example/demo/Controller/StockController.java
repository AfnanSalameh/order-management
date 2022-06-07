package com.example.demo.Controller;

import com.example.demo.Dto.CustomerDto;
import com.example.demo.Dto.StockDto;
import com.example.demo.Service.StockService;
import com.sun.deploy.association.utility.AppConstants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class StockController {
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @ApiOperation(value = "Create Stock REST API")
    @PreAuthorize("hasRole('ADMIN')")
    /*To support multiple roles with or condition*/
//    @PreAu    thorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    /*To support multiple roles with and condition*/
//    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")


    // get all Stocks rest api
    @GetMapping("/api/v1/stocks")
    public List<StockDto> getSCustomers() {
        List<StockDto> StockList = new ArrayList<StockDto>();
        for (int i = 0; i < 5; i++) {
            StockList.add(new StockDto("id","date","quantity"));
        }
        return StockList;
    }


    @ApiOperation(value = "Get Stock By Id REST API")
    // get Stock by id
    @GetMapping(value = "/api/v1/stocks/{id}")
    public ResponseEntity<StockDto> getStockByIdV1(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }



    @ApiOperation(value = "Delete Stock By Id REST API")
    @PreAuthorize("hasRole('ADMIN')")
    // delete Stock rest api
    @DeleteMapping("/api/v1/stocks/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable(name = "id") long id) {

        stockService.deleteStockById(id);

        return new ResponseEntity<>("Stock entity deleted successfully.", HttpStatus.OK);
    }
}
