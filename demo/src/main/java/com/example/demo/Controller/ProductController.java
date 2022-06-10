package com.example.demo.Controller;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Service.ProductService;
 import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

        @Api(value = "CRUD REST APIs for product")
        @RestController
        @RequestMapping("/api/product")
        public class productController {

                private final Logger log = LoggerFactory.getLogger(productController.class);


                @Autowired
                private ProductService product_service;

                public productController(ProductService product_service) {

                        this.product_service = product_service;
                }

                @DeleteMapping("/{id}")
                public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") int id) {
                        product_service.deleteProductById(id);
                        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
                }

                @GetMapping
                public ResponseEntity<List<ProductDto>> getAllProducts() {
                        return ResponseEntity.ok().body(product_service.getAllProducts()); //ResponseEntity represents an HTTP response, including headers, body, and status.
                }

                @GetMapping("/{id}")
                public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") int id) {
                        return ResponseEntity.ok(product_service.getProductById(id));
                }

                @PutMapping("/{id}")
                public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto product_Dto
                        , @PathVariable(name = "id") int id) {

                        return new ResponseEntity<>(product_service.updateProduct(product_Dto, id), HttpStatus.OK);
                }



                @GetMapping("/price/{price}")
                public List<ProductDto> findProductExceptPrice(@PathVariable(name = "price") double price) {

                        return product_service.findProductExceptPrice(price);
                }

                @GetMapping("/stock/{productId}")
                public List<ProductDto> findIsStockable(@PathVariable(name = "productId") int id) {
                        return product_service.findIsStockable(id);
                }
        }
}