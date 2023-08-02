package com.example.productmicroservice.service;

import com.example.productmicroservice.dto.ProductRequest;
import com.example.productmicroservice.dto.ProductResponse;
import com.example.productmicroservice.model.Product;
import com.example.productmicroservice.repositry.ProductRepositry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepositry productRepositry;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepositry.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepositry.findAll();

        return products.stream().map(this::productMapper).toList();
    }

    private ProductResponse productMapper(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
