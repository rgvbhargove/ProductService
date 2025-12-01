package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(@PathVariable("productId") Long productId);
    Product createProduct(Product product);
    Product replcateProduct(Product product);
    void deleteProduct(@PathVariable("productId") Long productId);

}
