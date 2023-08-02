package com.example.productmicroservice.repositry;

import com.example.productmicroservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepositry extends MongoRepository<Product, String> {

}
