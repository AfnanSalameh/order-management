package com.example.demo.Service.ServiceImp;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@Transactional
public abstract class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public @NotNull Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }



    @Override
    public Product getProduct(int id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));    }



    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public Product update(int id, Product productDTO) {
        Optional<Product> product = productRepository.findById(id);

        product.get().setId(productDTO.getId());
        product.get().setName(productDTO.getName());
        product.get().setReference(productDTO.getReference());
        product.get().getPrice(productDTO.getPrice());
        product.get().getVat(productDTO.getVat());


        Product result = productRepository.save(product.get());
        //todo you should use mappers to spperate the DTO and entities usage.
        return result;
    }


}