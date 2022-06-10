package com.example.demo.Service.ServiceImp;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public abstract class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> prods = productRepository.findAll();
        return prods.stream().map(prod -> mapToDTO(prod)).collect(Collectors.toList());

    }
    @Override
    public Product getProduct(int id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));    }

    @Override
    public Product update(int id, Product productDTO) {
        Optional<Product> product = productRepository.findById(id);

        product.get().setId(productDTO.getId());
        product.get().setName(productDTO.getName());
        product.get().setReference(productDTO.getReference());
        product.get().getPrice(productDTO.getPrice());
        product.get().getVat(productDTO.getVat());

        Product result = productRepository.save(product.get());
         return result;
    }

    @Override
    public void deleteProduct(int id) {
        Product prods = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        productRepository.delete(prods);
    }
    private ProductDto mapToDTO(Product prod){
        ProductDto product_Dto = new ProductDto();
        product_Dto.setId(prod.getId());
        product_Dto.setSlug(prod.getSlug());
        product_Dto.setName(prod.getName());
        product_Dto.setReference(prod.getReference());
        product_Dto.setPrice(prod.getPrice());
        product_Dto.setVat(prod.getVat());
        product_Dto.setStockable(prod.isStockable());

        return product_Dto;
    }

    private Product mapToEntity(ProductDto product_Dto){
        Product product = new Product();
        product.setSlug(product_Dto.getSlug());
        product.setName(product_Dto.getName());
        product.setReference(product_Dto.getReference());
        product.setPrice(product_Dto.getPrice());
        product.setVat(product_Dto.getVat());
        product.setStockable(product_Dto.isStockable());

        return product;

    }

}