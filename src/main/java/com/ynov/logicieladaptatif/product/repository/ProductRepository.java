package com.ynov.logicieladaptatif.product.repository;

import com.ynov.logicieladaptatif.product.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
