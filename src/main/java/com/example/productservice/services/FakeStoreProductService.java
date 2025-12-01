package com.example.productservice.services;

import DTOs.FakeStoreProductDto;
import com.example.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        FakeStoreProductDto[] fakeStoreProductDto = responseEntity.getBody();
        for(FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDto)
            {
            products.add(convertFakeStoreProductdtoToProduct(fakeStoreProductDto1));
            }

        return products;
    }

    @Override
    public Product getProductById(Long productId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products/"+productId, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();

        Product product = convertFakeStoreProductdtoToProduct(fakeStoreProductDto);

        return product;

    }

    private static Product convertFakeStoreProductdtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product=new Product();
        product.setTitle(fakeStoreProductDto.getProductName());
        product.setPrice(fakeStoreProductDto.getProductPrice());
        product.setDescription(fakeStoreProductDto.getProductDescription());
        product.setImageUrl(fakeStoreProductDto.getProductImageUrl());
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replcateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
