package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping ("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId)
    {
        //mke a HTTP call to FakeStore API to fetch the given product with id

        return productService.getProductById(productId);

    }

    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/id")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
        return null;
    }


}
