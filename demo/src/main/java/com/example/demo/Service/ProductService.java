package com.example.demo.Service;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product getProduct(int id);

    static Product getAllProduct() {
        return getAllProduct();
    }

    Product save(Product product);

    Product update(Long id, Product product);

    Product update(int id, Product productDTO);


    void delete(int productID);
}