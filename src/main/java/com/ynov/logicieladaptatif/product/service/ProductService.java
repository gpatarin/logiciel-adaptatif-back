package com.ynov.logicieladaptatif.product.service;

import com.ynov.logicieladaptatif.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> insertAll(Flux<Product> products);

    Flux<Product> findAll();

    Mono<Product> findById(String id);

    Mono<Product> save(Product product);

    Mono<Void> deleteById(String id);
}
